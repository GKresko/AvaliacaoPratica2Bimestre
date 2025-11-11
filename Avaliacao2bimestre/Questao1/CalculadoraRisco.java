package Questao1;

public class CalculadoraRisco {
    private AlgoritmoRisco algoritmo;
    private ContextoRisco contexto;

    public CalculadoraRisco(AlgoritmoRisco algoritmo, ContextoRisco contexto) {
        this.algoritmo = algoritmo;
        this.contexto = contexto;
    }

    public void setAlgoritmo(AlgoritmoRisco novoAlgoritmo) {
        System.out.println("Trocando para: " + novoAlgoritmo.getNome());
        this.algoritmo = novoAlgoritmo;
    }

    public double executar() {
        if (algoritmo == null) throw new IllegalStateException("Nenhum algoritmo definido!");
        System.out.println("Executando " + algoritmo.getNome());
        return algoritmo.calcular(contexto);
    }

    public ContextoRisco getContexto() {
        return contexto;
    }
}
