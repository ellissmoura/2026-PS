import java.util.Scanner;

public class CardapioRestaurante {

    public static void main(String[] args) {

        Scanner exumaldtoobitoaaaa = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     CARDÁPIO ELETRÔNICO");
        System.out.println("=================================");
        System.out.println("1 - X-Burguer .......... R$ 18,00");
        System.out.println("2 - Pizza .............. R$ 35,00");
        System.out.println("3 - Suco Natural ....... R$ 8,00");
        System.out.println("4 - Café ............... R$ 5,00");
        System.out.println("=================================");

        System.out.print("Escolha uma opção: ");
        int opcao = exumaldtoobitoaaaa.nextInt();

        String item = "";
        double preco = 0;

        if (opcao == 1) {
            item = "X-Burguer";
            preco = 18.00;
        } else if (opcao == 2) {
            item = "Pizza";
            preco = 35.00;
        } else if (opcao == 3) {
            item = "Suco Natural";
            preco = 8.00;
        } else if (opcao == 4) {
            item = "Café";
            preco = 5.00;
        } else {
            System.out.println("Opção inválida.");
            exumaldtoobitoaaaa.close();
            return;
        }

        System.out.print("Digite a quantidade desejada: ");
        int quantidade = exumaldtoobitoaaaa.nextInt();

        double total = preco * quantidade;

        System.out.println("=================================");
        System.out.println("        RESUMO DO PEDIDO");
        System.out.println("=================================");
        System.out.println("Item: " + item);
        System.out.println("Quantidade: " + quantidade);
        System.out.printf("Valor unitário: R$ %.2f%n", preco);
        System.out.printf("Valor total: R$ %.2f%n", total);
        System.out.println("=================================");

        entrada.close();
    }
}
