package Questao2;

import java.util.HashMap;
import java.util.Map;

/**
 * Adapter que converte chamadas do novo formato (ProcessadorTransacoes)
 * para o formato legado (SistemaBancarioLegado) e vice-versa.
 */
public class AdaptadorSistemaBancario implements ProcessadorTransacoes {

    private SistemaBancarioLegado sistemaLegado;

    public AdaptadorSistemaBancario(SistemaBancarioLegado sistemaLegado) {
        this.sistemaLegado = sistemaLegado;
    }

    @Override
    public TransacaoResposta autorizar(String cartao, double valor, String moeda) {
        // Monta parâmetros no formato legado
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("numeroCartao", cartao);
        parametros.put("valor", valor);
        parametros.put("codigoMoeda", converterMoedaParaCodigo(moeda));

        // Adiciona campo obrigatório que não existe no moderno
        parametros.put("canalOrigem", "API_MODERNA"); // obrigatório no legado

        // Chama o sistema legado
        Map<String, Object> respostaLegado = sistemaLegado.processarTransacao(parametros);

        // Converte a resposta do legado para formato moderno
        return converterRespostaParaModerno(respostaLegado);
    }

    private int converterMoedaParaCodigo(String moeda) {
        switch (moeda.toUpperCase()) {
            case "USD": return 1;
            case "EUR": return 2;
            case "BRL": return 3;
            default: throw new IllegalArgumentException("Moeda não suportada: " + moeda);
        }
    }

    private String converterCodigoParaMoeda(int codigo) {
        switch (codigo) {
            case 1: return "USD";
            case 2: return "EUR";
            case 3: return "BRL";
            default: return "DESCONHECIDA";
        }
    }

    private TransacaoResposta converterRespostaParaModerno(Map<String, Object> respostaLegado) {
        String status = (String) respostaLegado.get("status");
        String mensagem = (String) respostaLegado.get("mensagem");
        int codigo = (int) respostaLegado.getOrDefault("codigoRetorno", -1);
        String codAutorizacao = (String) respostaLegado.getOrDefault("codigoAutorizacao", "N/A");

        return new TransacaoResposta(status, mensagem, codigo, codAutorizacao);
    }
}
