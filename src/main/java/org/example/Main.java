import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int quantidadePedidos = 0;
        double totalVendas = 0;
        double maiorCompra = 0;
        double menorCompra = 0;

        int opcao = 1;

        System.out.println("=== SISTEMA DE PEDIDOS ===");

        while (opcao == 1) {

            System.out.print("Nome do cliente: ");
            String nome = scanner.nextLine();

            double valor;

            do {
                System.out.print("Valor da compra: R$ ");
                String valorDigitado = scanner.nextLine();

                valor = Double.parseDouble(valorDigitado.replace(",", "."));

                if (valor <= 0) {
                    System.out.println("O valor deve ser maior que zero.");
                }

            } while (valor <= 0);

            quantidadePedidos++;
            totalVendas += valor;

            if (quantidadePedidos == 1) {
                maiorCompra = valor;
                menorCompra = valor;
            } else {
                if (valor > maiorCompra) {
                    maiorCompra = valor;
                }

                if (valor < menorCompra) {
                    menorCompra = valor;
                }
            }

            System.out.println("\nCadastrar novo pedido?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(scanner.nextLine());
            System.out.println();
        }

        double ticketMedio = totalVendas / quantidadePedidos;

        System.out.println("===== RELATÓRIO FINAL =====");
        System.out.println("Quantidade de pedidos: " + quantidadePedidos);
        System.out.printf("Valor total vendido: R$ %.2f%n", totalVendas);
        System.out.printf("Ticket médio: R$ %.2f%n", ticketMedio);
        System.out.printf("Maior compra: R$ %.2f%n", maiorCompra);
        System.out.printf("Menor compra: R$ %.2f%n", menorCompra);

        scanner.close();
    }
}