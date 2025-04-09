import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ServiceOrderManager serviceOrderManager = new ServiceOrderManager();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("====== MENU - ORDEM DE SERVIÇO ======\n");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Criar ordem de serviço");
            System.out.println("3 - Listar todas as ordens");
            System.out.println("4 - Concluir ordem serviço");
            System.out.println("5 - Listar ordens por cliente");
            System.out.println("6 - Sair\n");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.print("Informe seu nome: ");
                    String nomeCadastro = scanner.nextLine();
                    System.out.print("Informe seu CPF: ");
                    String cpfCadastro = scanner.nextLine();
                    serviceOrderManager.cadastrarCliente(nomeCadastro, cpfCadastro);
                    break;

                case 2:
                    System.out.print("Informe seu CPF: ");
                    String cpfCriarOrdem = scanner.nextLine();
                    System.out.print("Descição da ordem: ");
                    String descricaoOrdem = scanner.nextLine();
                    System.out.print("Tipo da ordem: ");
                    String tipoOrdem = scanner.nextLine();
                    serviceOrderManager.criarOrdemDeServico(cpfCriarOrdem, descricaoOrdem, tipoOrdem);
                    break;

                case 3:
                    serviceOrderManager.listarOrdens();
                    break;

                case 4:
                    System.out.print("Informe o ID da ordem a ser concluída: ");
                    int idConcluido = scanner.nextInt();
                    serviceOrderManager.concluirOrdem(idConcluido);
                    break;

                case 5:
                    System.out.print("Informe seu CPF: ");
                    String cpfOrdensPorCliente = scanner.nextLine();
                    serviceOrderManager.listarOrdensPorCliente(cpfOrdensPorCliente);
                    break;

                case 6:
                    System.out.println("Saindo do Sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");

            }
        } while (opcao != 6);


        scanner.close();
    }
}
