package Questao2;

import java.util.HashMap;
import java.util.Map;

/**
 * Simula o sistema bancário legado com interface antiga.
 * Ele recebe um HashMap com parâmetros e retorna outro HashMap como resposta.
 */
public class SistemaBancarioLegado {

    public Map<String, Object> processarTransacao(HashMap<String, Object> parametros) {
        Map<String, Object> resposta = new HashMap<>();

        // Verifica campos obrigatórios
        if (!parametros.containsKey("codigoMoeda") || !parametros.containsKey("numeroCartao") || !parametros.containsKey("valor")) {
            resposta.put("status", "ERRO");
            resposta.put("mensagem", "Campos obrigatórios ausentes (codigoMoeda, numeroCartao ou valor).");
            return resposta;
        }

        // Simula autorização (dummy)
        int codigoMoeda = (int) parametros.get("codigoMoeda");
        String moeda = codigoMoeda == 1 ? "USD" : codigoMoeda == 2 ? "EUR" : "BRL";
        double valor = (double) parametros.get("valor");
        String cartao = (String) parametros.get("numeroCartao");

        System.out.printf("[LEGADO] Processando transação Cartão: %s | Valor: %.2f | Moeda: %s%n", cartao, valor, moeda);

        // Dummy: se valor for maior que 1000, recusa
        if (valor > 1000) {
            resposta.put("status", "NEGADO");
            resposta.put("codigoRetorno", 500);
            resposta.put("mensagem", "Transação negada pelo sistema legado.");
        } else {
            resposta.put("status", "APROVADO");
            resposta.put("codigoRetorno", 200);
            resposta.put("mensagem", "Transação aprovada com sucesso.");
        }

        // Campo legado adicional obrigatório (exemplo)
        resposta.put("codigoAutorizacao", "LGD" + System.currentTimeMillis());

        return resposta;
    }
}
