import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiceOrderManager {
    private Map<String, Client> clientes;
    private ArrayList<ServiceOrder> ordens;
    private int proximoId;

    public ServiceOrderManager(){
        this.clientes = new HashMap<>();
        this.ordens = new ArrayList<>();
        this.proximoId = 1;
    }

    public void cadastrarCliente(String nome, String cpf){
        if(!clientes.containsKey(cpf)){
            Client client = new Client(nome, cpf);
            clientes.put(cpf, client);
            System.out.println("Cliente cadastrado!");
        } else {
            System.out.println("O CPF informado já está cadastrado no sistema!");
        }
    }

    public void criarOrdemDeServico(String cpf, String descricao, String tipo){
        if(clientes.containsKey(cpf)){
            Client client = clientes.get(cpf);
            ServiceOrder ordem = new ServiceOrder(descricao, tipo, client);
            ordem.setId(proximoId);
            proximoId++;
            ordens.add(ordem);
            System.out.println("Ordem de Serivço Criada com Sucesso!");
        } else {
            System.out.println("Cliente não encontrado. Verifique o CPF.");
        }
    }

    public void listarOrdens(){
        if(ordens.isEmpty()){
            System.out.println("Nenhuma ordem cadastrada.");
            return;
        }

        for(ServiceOrder so: ordens){
            so.exibirDetalhes();
        }
    }

    public void concluirOrdem(int id){
        boolean encontrada = false;
        for(ServiceOrder ordem: ordens){
            if(ordem.getId() == id){
                ordem.marcarComoConcluido();
                encontrada = true;
                break;
            }
        }

        if(!encontrada){
            System.out.println("Ordem com ID ' "+ id +" ' não encontrada.");
        }
    }

    public void listarOrdensPorCliente(String cpf){
        if(clientes.containsKey(cpf)){
            boolean encontrou = false;
            for(ServiceOrder ordem: ordens){
                if(ordem.getClient().getCpf().equals(cpf)){
                    ordem.exibirDetalhes();
                    encontrou = true;
                }
            }

            if(!encontrou){
                System.out.println("Esse cliente ainda não possui ordens de Serviço.");
            }
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
}
