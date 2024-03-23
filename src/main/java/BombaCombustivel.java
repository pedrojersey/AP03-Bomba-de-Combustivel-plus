import java.util.HashMap;
import java.util.Map;


class BombaCombustivel {
    private Map<String, Double> precosCombustiveis;
    private Map<String, Double> quantidadeCombustiveis;
    private double valorTotalAbastecido;

    public BombaCombustivel() {
        this.precosCombustiveis = new HashMap<String,Double>();
        this.quantidadeCombustiveis = new HashMap<String,Double>();
        this.valorTotalAbastecido = 0.0;

        precosCombustiveis.put("Gasolina Comum", 5.0); 
        precosCombustiveis.put("Gasolina Aditivada", 5.5);
        precosCombustiveis.put("Álcool", 4.0);
        precosCombustiveis.put("Diesel", 4.5);

        quantidadeCombustiveis.put("Gasolina Comum", 1000.0);
        quantidadeCombustiveis.put("Gasolina Aditivada", 800.0);
        quantidadeCombustiveis.put("Álcool", 1200.0);
        quantidadeCombustiveis.put("Diesel", 1500.0);
    }

    public Map<String, Double> getPrecosCombustiveis() {
        return precosCombustiveis;
    }

    public void abastecerPorValor(String tipoCombustivel, double valor) {
        double precoLitro = precosCombustiveis.get(tipoCombustivel);
        double litrosAbastecidos = valor / precoLitro;
        double quantidadeDisponivel = quantidadeCombustiveis.get(tipoCombustivel);

        if (litrosAbastecidos <= quantidadeDisponivel) {
            quantidadeCombustiveis.put(tipoCombustivel, quantidadeDisponivel - litrosAbastecidos);
            valorTotalAbastecido += valor;
            System.out.println("Foram abastecidos " + litrosAbastecidos + " litros de " + tipoCombustivel);
        } else {
            System.out.println("Não há combustível suficiente de " + tipoCombustivel);
        }
    }

    public void abastecerPorLitro(String tipoCombustivel, double litros) {
        double precoLitro = precosCombustiveis.get(tipoCombustivel);
        double valorPagar = litros * precoLitro;
        double quantidadeDisponivel = quantidadeCombustiveis.get(tipoCombustivel);

        if (litros <= quantidadeDisponivel) {
            quantidadeCombustiveis.put(tipoCombustivel, quantidadeDisponivel - litros);
            valorTotalAbastecido += valorPagar;
            System.out.println("O valor a ser pago é R$ " + valorPagar + " pelo abastecimento de " + litros + " litros de " + tipoCombustivel);
        } else {
            System.out.println("Não há combustível suficiente de " + tipoCombustivel);
        }
    }

    public void alterarValor(String tipoCombustivel, double novoValor) {
        precosCombustiveis.put(tipoCombustivel, novoValor);
    }

    public void alterarQuantidadeCombustivel(String tipoCombustivel, double novaQuantidade) {
        quantidadeCombustiveis.put(tipoCombustivel, novaQuantidade);
    }

    public double getValorTotalAbastecido() {
        return valorTotalAbastecido;
    }
}