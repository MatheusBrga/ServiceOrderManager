public class ServiceOrder {
    private int id;
    private String descricao;
    private String tipo;
    private boolean status;
    private Client client;

    public ServiceOrder(int id, String descricao, String tipo, boolean status, Client client){
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.status = status;
        this.client = client;
    }

    public ServiceOrder(String descricao, String tipo, Client client) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.client = client;
        this.status = false;
    }

    public void setId(int id){

        this.id = id;
    }

    public int getId() {

        return id;
    }

    public String getDescricao() {

        return descricao;
    }

    public String getTipo() {

        return tipo;
    }

    public Client getClient() {
        return client;
    }

    public void marcarComoConcluido(){
        status = true;
        System.out.println("Ordem concluída!");
    }

    public void exibirDetalhes(){
        System.out.println("=== INFORMAÇÕES DA ORDEM ===");
        System.out.println("Nome do Cliente: " + client.getNome());
        System.out.println("CPF do Cliente: " + client.getCpf());
        System.out.println("ID: " + id);
        System.out.println("Descrição da Ordem: " + descricao);
        System.out.println("Tipo da Ordem: " + tipo);
        System.out.println("Status: " + status);
    }


}
