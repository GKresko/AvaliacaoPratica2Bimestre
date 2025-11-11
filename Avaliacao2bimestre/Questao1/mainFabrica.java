package Questao1;

public class mainFabrica {
    public static void main(String[] args) {
        FabricaPadraoAlgoritmosRisco fabrica = new FabricaPadraoAlgoritmosRisco();

        // Cria o contexto de risco
        ContextoRisco contexto = new ContextoRisco(10_000_000.0, 0.95, 0.025);
        contexto.adicionarPosicao("Ações", 4_000_000);
        contexto.adicionarPosicao("Renda Fixa", 3_000_000);
        contexto.adicionarPosicao("Derivativos", 3_000_000);

        // Começa com VaR
        CalculadoraRisco calc = new CalculadoraRisco(fabrica.criarAlgoritmo("var"), contexto);
        calc.executar();

        System.out.println("\n--- Mudando para Perda Esperada ---");
        calc.setAlgoritmo(fabrica.criarAlgoritmo("perdaesperada"));
        calc.executar();

        System.out.println("\n--- Mudando para Teste de Estresse ---");
        contexto.setCenarioEstresse("crise2008");
        calc.setAlgoritmo(fabrica.criarAlgoritmo("estresse"));
        calc.executar();

        System.out.println("\n--- Mudando novamente para VaR com 99% ---");
        contexto.setCenarioEstresse("normal");
        contexto = new ContextoRisco(10_000_000.0, 0.99, 0.025);
        calc.setAlgoritmo(fabrica.criarAlgoritmo("var"));
        calc = new CalculadoraRisco(calc.getContexto().getValorCarteira() > 0 ? fabrica.criarAlgoritmo("var") : null, contexto);
        calc.executar();
    }
}
