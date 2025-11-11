package Questao1;

public class AlgoritmoTesteEstresse implements AlgoritmoRisco {
    @Override
    public String getNome() {
        return "Algoritmo Teste de Estresse";
    }

    @Override
    public double calcular(ContextoRisco contexto) {
        double impacto = 0.20; // padrão
        switch (contexto.getCenarioEstresse().toLowerCase()) {
            case "crise2008": impacto = 0.45; break;
            case "pandemia": impacto = 0.30; break;
            case "leve": impacto = 0.10; break;
        }
        double perda = contexto.getValorCarteira() * impacto;
        System.out.printf("[Estresse] Cenário: %s | Impacto: %.2f%% => Perda: %.2f%n",
                contexto.getCenarioEstresse(), impacto * 100, perda);
        return perda;
    }
}
