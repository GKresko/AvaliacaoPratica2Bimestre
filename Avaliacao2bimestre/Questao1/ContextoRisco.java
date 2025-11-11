package Questao1;

import java.util.HashMap;
import java.util.Map;

public class ContextoRisco {
    private double valorCarteira;
    private double nivelConfianca;
    private double volatilidadeHistorica;
    private String cenarioEstresse;
    private Map<String, Double> posicoes;

    public ContextoRisco(double valorCarteira, double nivelConfianca, double volatilidadeHistorica) {
        this.valorCarteira = valorCarteira;
        this.nivelConfianca = nivelConfianca;
        this.volatilidadeHistorica = volatilidadeHistorica;
        this.cenarioEstresse = "normal";
        this.posicoes = new HashMap<>();
    }

    public void adicionarPosicao(String nome, double valor) {
        posicoes.put(nome, valor);
    }

    public double getValorCarteira() { return valorCarteira; }
    public double getNivelConfianca() { return nivelConfianca; }
    public double getVolatilidadeHistorica() { return volatilidadeHistorica; }
    public String getCenarioEstresse() { return cenarioEstresse; }
    public void setCenarioEstresse(String cenarioEstresse) { this.cenarioEstresse = cenarioEstresse; }
}
