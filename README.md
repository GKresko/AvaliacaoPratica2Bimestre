Questão 1 – Sistema de Cálculo de Risco Financeiro (Factory + Strategy)

Objetivo:
Implementar um sistema de cálculo de métricas de risco (Value at Risk, Perda Esperada e Teste de Estresse) que permita trocar dinamicamente o algoritmo em tempo de execução.

Conceitos utilizados:

Padrão Strategy: cada algoritmo de risco implementa a interface AlgoritmoRisco com o método calcular(ContextoRisco contexto).

Padrão Factory Method: a classe FabricaPadraoAlgoritmosRisco cria instâncias do algoritmo desejado com base em um identificador (var, perdaesperada, estresse).

Contexto compartilhado: ContextoRisco contém parâmetros financeiros como exposição, volatilidade, taxa de juros, etc.

Arquivos criados:

AlgoritmoRisco.java
AlgoritmoVaR.java
AlgoritmoPerdaEsperada.java
AlgoritmoTesteEstresse.java
ContextoRisco.java
FabricaAlgoritmosRisco.java
FabricaPadraoAlgoritmosRisco.java
CalculadoraRisco.java
mainFabrica.java


Resumo:
O cliente escolhe o algoritmo de forma genérica (sem conhecer a implementação interna) e o sistema executa o cálculo correspondente.
Cada algoritmo imprime um resultado simulado (dummy) representando o cálculo de risco.

Questão 2 – Integração com Sistema Bancário Legado (Adapter Pattern)

Objetivo:
Permitir a comunicação entre um novo processador moderno (ProcessadorTransacoes) e o sistema bancário legado, que usa métodos e estruturas incompatíveis.

Conceitos utilizados:

Padrão Adapter: a classe AdaptadorSistemaBancario converte chamadas do novo formato (autorizar(String cartao, double valor, String moeda)) para o formato legado (processarTransacao(HashMap<String, Object> parametros)).

Conversão bidirecional: respostas do sistema legado também são convertidas de volta para o formato moderno.

Tratamento de campos obrigatórios: o adaptador adiciona campos extras exigidos pelo legado (ex: código da agência, tipo de operação).

Mapeamento de moedas: USD = 1, EUR = 2, BRL = 3.

Arquivos criados:

ProcessadorTransacoes.java
SistemaBancarioLegado.java
AdaptadorSistemaBancario.java
mainBanco.java


Resumo:
A aplicação moderna chama o método autorizar(), e o adaptador traduz tudo para o formato antigo sem que o cliente precise conhecer detalhes técnicos do legado.

Questão 3 – Controle de Estados da Usina Nuclear (State Pattern)

Objetivo:
Modelar os estados complexos de uma usina nuclear (DESLIGADA, OPERACAO_NORMAL, ALERTA_AMARELO, ALERTA_VERMELHO, EMERGENCIA) com regras de transição e segurança.

Conceitos utilizados:

Padrão State: cada estado é uma classe concreta que herda de EstadoUsina.

Validação de transições: só permite mudança se condições como temperatura, pressão e radiação forem válidas.

Prevenção de transições perigosas: bloqueia ciclos e exige passagem obrigatória por ALERTA_VERMELHO antes de EMERGENCIA.

Modo de manutenção: permite forçar o estado independentemente das condições, simulando manutenção técnica.

Arquivos criados:

EstadoUsina.java
EstadoDesligada.java
EstadoOperacaoNormal.java
EstadoAlertaAmarelo.java
EstadoAlertaVermelho.java
EstadoEmergencia.java
UsinaNuclear.java
mainUsina.java


Resumo:
O sistema simula a operação da usina, validando parâmetros antes de mudar de estado. Caso o resfriamento falhe, o sistema entra em modo de emergência.
Há também um modo de “manutenção” que sobrepõe temporariamente as validações.

Questão 4 – Validação de NF-e com Cadeia de Responsabilidade (Chain of Responsibility)

Objetivo:
Construir uma cadeia de validadores especializados que processam um documento fiscal (NF-e) com múltiplas regras e controle de falhas.

Conceitos utilizados:

Padrão Chain of Responsibility: cada classe Validador executa sua verificação e passa o controle para o próximo.

Circuit Breaker: se 3 validações falharem, a cadeia é interrompida automaticamente.

Rollback: se um validador posterior falhar, validadores anteriores podem reverter alterações no documento.

Timeout individual: cada validador tem tempo máximo de execução.

Execução condicional: alguns validadores (ex: fiscais e SEFAZ) só executam se os anteriores passare
