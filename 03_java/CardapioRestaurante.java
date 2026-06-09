import java.util.Scanner;
import java.util.Random;

public class CardapioRestaurante {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        boolean continuar = true;
        double totalPedido = 0;
        String resumo = "";

        while (continuar) {
            System.out.println("=================================");
            System.out.println("     CARDÁPIO ELETRÔNICO");
            System.out.println("=================================");
            System.out.println("1 - Whopper .......... R$ 18,00");
            System.out.println("2 - Cachorro-orelha .............. R$ 35,00");
            System.out.println("3 - Batata Frita ....... R$ 12,00");
            System.out.println("4 - Refrigerante ....... R$ 8,00");
            System.out.println("5 - Sorvete ............ R$ 10,00");
            System.out.println("6 - Finalizar Pedido");
            System.out.println("=================================");

            System.out.print("Escolha uma opção: ");
            int opcao = entrada.nextInt();

            String item = "";
            double preco = 0;

            switch (opcao) {
                case 1:
                    item = "Whopper";
                    preco = 18.00;
                    break;
                case 2:
                    item = "Cachorro-orelha";
                    preco = 35.00;
                    break;
                case 3:
                    item = "Batata Frita";
                    preco = 12.00;
                    break;
                case 4:
                    item = "Refrigerante";
                    preco = 8.00;
                    break;
                case 5:
                    item = "Sorvete";
                    preco = 10.00;
                    break;
                case 6:
                    System.out.print("Deseja realmente finalizar o pedido? (1 - Sim / 2 - Não): ");
                    int confirmar = entrada.nextInt();
                    if (confirmar == 1) {
                        continuar = false; // encerra o loop
                    } else {
                        continuar = true;  // volta ao cardápio
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            if (opcao >= 1 && opcao <= 5) {
                System.out.print("Digite a quantidade desejada: ");
                int quantidade = entrada.nextInt();

                double subtotal = preco * quantidade;
                totalPedido += subtotal;

                resumo += item + " (x" + quantidade + ") - R$ " + String.format("%.2f", subtotal) + "\n";

                System.out.println(item + " adicionado ao pedido.");
            }
        }

        System.out.println("=================================");
        System.out.println("        RESUMO DO PEDIDO");
        System.out.println("=================================");
        System.out.print(resumo);
        System.out.printf("TOTAL: R$ %.2f%n", totalPedido);
        System.out.println("=================================");

        System.out.println("Formas de pagamento:");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão");
        System.out.println("3 - PIX");
        System.out.println("4 - Cheque");
        System.out.print("Escolha a forma de pagamento: ");
        int pagamento = entrada.nextInt();

        switch (pagamento) {
            case 1:
                System.out.println("Pagamento em Dinheiro selecionado.");
                break;
            case 2:
                System.out.println("Pagamento em Cartão selecionado.");
                break;
            case 3:
                System.out.println("Pagamento via PIX selecionado.");
                break;
            case 4:
                System.out.println("Pagamento de Cheque selecionado.");
                break;
            default:
                System.out.println("Forma de pagamento inválida.");
                break;
        }

        int numeroPedido = random.nextInt(9000) + 1000; // número aleatório entre 1000 e 9999
        System.out.println("=================================");
        System.out.println("Seu número de pedido é: " + numeroPedido);
        System.out.println("Aguarde a chamada do seu pedido.");
        System.out.println("=================================");

        entrada.close();
    }
}
