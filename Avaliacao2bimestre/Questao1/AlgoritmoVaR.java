package Questao1;

public class AlgoritmoVaR implements AlgoritmoRisco {
    @Override
    public String getNome() {
        return "Algoritmo Value at Risk (VaR)";
    }

    @Override
    public double calcular(ContextoRisco contexto) {
        double z = (contexto.getNivelConfianca() == 0.99) ? 2.33 : 1.65;
        double var = contexto.getValorCarteira() * contexto.getVolatilidadeHistorica() * z;
        System.out.printf("[VaR] Nível: %.2f | Volatilidade: %.3f | Z: %.2f => Resultado: %.2f%n",
                contexto.getNivelConfianca(), contexto.getVolatilidadeHistorica(), z, var);
        return var;
    }
}
