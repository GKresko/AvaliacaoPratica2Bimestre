package Questao1;

public class AlgoritmoPerdaEsperada implements AlgoritmoRisco {
    @Override
    public String getNome() {
        return "Algoritmo Perda Esperada (Expected Shortfall)";
    }

    @Override
    public double calcular(ContextoRisco contexto) {
        AlgoritmoVaR varCalc = new AlgoritmoVaR();
        double var = varCalc.calcular(contexto);
        double perdaEsperada = var * 1.2;
        System.out.printf("[PerdaEsperada] Usando VaR=%.2f -> Resultado: %.2f%n", var, perdaEsperada);
        return perdaEsperada;
    }
}
