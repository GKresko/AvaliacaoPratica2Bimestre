package Questao1;

public class FabricaPadraoAlgoritmosRisco implements FabricaAlgoritmosRisco {
    public AlgoritmoRisco criarAlgoritmo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "var":
                return new AlgoritmoVaR();
            case "perdaesperada":
                return new AlgoritmoPerdaEsperada();
            case "estresse":
                return new AlgoritmoTesteEstresse();
            default:
                throw new IllegalArgumentException("Tipo de algoritmo desconhecido: " + tipo);
        }
    }
}
