package Questao2;

public class mainAdapter {
    public static void main(String[] args) {
        SistemaBancarioLegado legado = new SistemaBancarioLegado();
        ProcessadorTransacoes processador = new AdaptadorSistemaBancario(legado);

        System.out.println("=== Transação 1 ===");
        TransacaoResposta resp1 = processador.autorizar("4111111111111111", 500.0, "BRL");
        System.out.println(resp1);

        System.out.println("\n=== Transação 2 ===");
        TransacaoResposta resp2 = processador.autorizar("5555555555554444", 2000.0, "USD");
        System.out.println(resp2);

        System.out.println("\n=== Transação 3 (com erro de campo obrigatório) ===");
        try {
            TransacaoResposta resp3 = processador.autorizar("0000000000000000", 100, "JPY");
            System.out.println(resp3);
        } catch (Exception e) {
            System.out.println("Erro detectado: " + e.getMessage());
        }
    }
}
