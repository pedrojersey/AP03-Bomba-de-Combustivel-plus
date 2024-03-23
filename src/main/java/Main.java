import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BombaCombustivel bomba = new BombaCombustivel();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Abastecer por valor");
            System.out.println("2. Abastecer por litro");
            System.out.println("3. Alterar valor do litro");
            System.out.println("4. Verificar valor total abastecido");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo de combustível:");
                    exibirOpcoesCombustiveis(bomba);
                    int tipoValor = scanner.nextInt();
                    System.out.println("Digite o valor a ser abastecido:");
                    double valorAbastecimento = scanner.nextDouble();
                    bomba.abastecerPorValor(obterTipoCombustivel(tipoValor), valorAbastecimento);
                    break;
                case 2:
                    System.out.println("Escolha o tipo de combustível:");
                    exibirOpcoesCombustiveis(bomba);
                    int tipoLitro = scanner.nextInt();
                    System.out.println("Digite a quantidade de litros a ser abastecida:");
                    double litrosAbastecimento = scanner.nextDouble();
                    bomba.abastecerPorLitro(obterTipoCombustivel(tipoLitro), litrosAbastecimento);
                    break;
                case 3:
                    System.out.println("Escolha o tipo de combustível:");
                    exibirOpcoesCombustiveis(bomba);
                    int tipoAlterar = scanner.nextInt();
                    System.out.println("Digite o novo valor do litro:");
                    double novoValor = scanner.nextDouble();
                    bomba.alterarValor(obterTipoCombustivel(tipoAlterar), novoValor);
                    break;
                case 4:
                    System.out.println("O valor total abastecido é: R$ " + bomba.getValorTotalAbastecido());
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Escolha uma opção de 1 a 5.");
            }
        }
    }

    private static void exibirOpcoesCombustiveis(BombaCombustivel bomba) {
        int i = 1;
        for (String tipo : bomba.getPrecosCombustiveis().keySet()) {
            System.out.println(i + ". " + tipo);
            i++;
        }
    }

    private static String obterTipoCombustivel(int escolha) {
        switch (escolha) {
            case 1:
                return "Gasolina Comum";
            case 2:
                return "Gasolina Aditivada";
            case 3:
                return "Álcool";
            case 4:
                return "Diesel";
            default:
                return null;
        }
    }
}