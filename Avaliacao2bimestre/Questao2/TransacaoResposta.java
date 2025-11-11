/**
 * Representa a resposta padronizada do novo sistema.
 */
package Questao2;

public class TransacaoResposta {
    private String status;
    private String mensagem;
    private int codigoRetorno;
    private String codigoAutorizacao;

    public TransacaoResposta(String status, String mensagem, int codigoRetorno, String codigoAutorizacao) {
        this.status = status;
        this.mensagem = mensagem;
        this.codigoRetorno = codigoRetorno;
        this.codigoAutorizacao = codigoAutorizacao;
    }

    @Override
    public String toString() {
        return String.format("Status: %s | Código: %d | Mensagem: %s | Autorização: %s",
                status, codigoRetorno, mensagem, codigoAutorizacao);
    }
}
