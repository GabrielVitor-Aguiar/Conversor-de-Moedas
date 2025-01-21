package com.conversor;

import java.util.Scanner;

public class ConversorMoeda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateService service = new ExchangeRateService();

        while (true) {
            System.out.println("\nBem-vindo ao Conversor de Moedas!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Dólar (USD) para Real (BRL)");
            System.out.println("2. Euro (EUR) para Real (BRL)");
            System.out.println("3. Iene (JPY) para Real (BRL)");
            System.out.println("4. Real (BRL) para Dólar (USD)");
            System.out.println("5. Real (BRL) para Euro (EUR)");
            System.out.println("6. Real (BRL) para Iene (JPY)");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Obrigado por usar o conversor!");
                break;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            try {
                double taxa = 0.0;
                switch (opcao) {
                    case 1:
                        taxa = service.getExchangeRate("USD", "BRL");
                        break;
                    case 2:
                        taxa = service.getExchangeRate("EUR", "BRL");
                        break;
                    case 3:
                        taxa = service.getExchangeRate("JPY", "BRL");
                        break;
                    case 4:
                        taxa = service.getExchangeRate("BRL", "USD");
                        break;
                    case 5:
                        taxa = service.getExchangeRate("BRL", "EUR");
                        break;
                    case 6:
                        taxa = service.getExchangeRate("BRL", "JPY");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        continue;
                }
                double resultado = valor * taxa;
                System.out.printf("Resultado: %.2f%n", resultado);
            } catch (Exception e) {
                System.out.println("Erro ao realizar a conversão: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
