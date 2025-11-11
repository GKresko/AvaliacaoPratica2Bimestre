/**
 * Interface moderna do novo sistema financeiro.
 * Esta é a API que os sistemas novos irão usar.
 */
package Questao2;

public interface ProcessadorTransacoes {
    TransacaoResposta autorizar(String cartao, double valor, String moeda);
}
