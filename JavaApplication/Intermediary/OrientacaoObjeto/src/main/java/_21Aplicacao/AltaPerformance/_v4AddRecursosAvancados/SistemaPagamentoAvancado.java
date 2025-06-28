package _21Aplicacao.AltaPerformance._v4AddRecursosAvancados;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

// Versão mais avançada, próxima da original

final class DadosCartao {
    private final String numero;
    private final String dataValidade;
    private final String cvv;

    public DadosCartao(String numero, String dataValidade, String cvv) {
        this.numero = numero;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
    }

    public String getNumero() { return numero; }
    public String getDataValidade() { return dataValidade; }
    public String getCvv() { return cvv; }
}

interface PagamentoHandler {
    void processar(double valor, String idTransacao);
    String obterDetalhes();
}

class CartaoHandler implements PagamentoHandler {
    private final DadosCartao dados;
    private static final AtomicInteger counter = new AtomicInteger();
    private final int instanceId = counter.incrementAndGet();

    public CartaoHandler(DadosCartao dados) {
        this.dados = dados;
    }

    @Override
    public void processar(double valor, String idTransacao) {
        System.out.printf("[%s] Processando cartão %s - R$%.2f%n",
                idTransacao, dados.getNumero().substring(0, 4) + "****", valor);
    }

    @Override
    public String obterDetalhes() {
        return "Cartão[" + instanceId + "] - Final " +
                dados.getNumero().substring(dados.getNumero().length() - 4);
    }
}

class PixHandler implements PagamentoHandler {
    private final String chave;

    public PixHandler(String chave) {
        this.chave = chave;
    }

    @Override
    public void processar(double valor, String idTransacao) {
        System.out.printf("[%s] Processando PIX %s - R$%.2f%n",
                idTransacao, chave, valor);
    }

    @Override
    public String obterDetalhes() {
        return "PIX - " + (chave.length() > 10 ? chave.substring(0, 10) + "..." : chave);
    }
}

class PagamentoExecutor {
    private final ExecutorService executor;
    private final AtomicLong tasksProcessed = new AtomicLong();

    public PagamentoExecutor() {
        this.executor = Executors.newWorkStealingPool();
    }

    public CompletableFuture<Void> processarAsync(PagamentoHandler handler,
                                                  double valor,
                                                  String idTransacao) {
        CompletableFuture<Void> future = new CompletableFuture<>();

        executor.execute(() -> {
            handler.processar(valor, idTransacao);
            tasksProcessed.incrementAndGet();
            future.complete(null);
        });

        return future;
    }

    public void shutdown() throws InterruptedException {
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
    }

    public long getTasksProcessed() { return tasksProcessed.get(); }
}

public class SistemaPagamentoAvancado {
    public static void main(String[] args) throws InterruptedException {
        PagamentoExecutor executor = new PagamentoExecutor();

        DadosCartao cartao = new DadosCartao("1234567890123456", "12/25", "123");
        PagamentoHandler cartaoHandler = new CartaoHandler(cartao);
        PagamentoHandler pixHandler = new PixHandler("chave@exemplo.com");

        // Callback de conclusão
        Consumer<PagamentoHandler> callback = handler ->
                System.out.println("Concluído: " + handler.obterDetalhes());

        for (int i = 0; i < 20; i++) {
            String id = "TX" + System.currentTimeMillis() + "-" + i;
            double valor = 50 + (i * 5);

            CompletableFuture<Void> future = executor.processarAsync(
                    i % 3 == 0 ? cartaoHandler : pixHandler,
                    valor,
                    id
            );

            int finalI = i;
            future.thenRun(() -> callback.accept(finalI % 3 == 0 ? cartaoHandler : pixHandler));
        }

        executor.shutdown();
        System.out.println("Total processado: " + executor.getTasksProcessed());
    }
}

/**
 * Versão 4: Abordagem Avançada
 * Recursos adicionados:
 *     CompletableFuture para programação assíncrona mais poderosa
 *     Callbacks para tratamento pós-processamento
 *     Contador atômico de tarefas processadas
 *     WorkStealingPool para melhor aproveitamento de CPU
 *     Métricas básicas (tasksProcessed)
 * Conceitos importantes:
 *     Programação reativa com Futures
 *     Composição de operações assíncronas
 *     Atomicidade para contagem em ambiente concorrente
 *     Work-stealing para melhor balanceamento de carga
 */


/**
 * Evolução dos Principais Componentes
 * 1. Tratamento de Pagamentos
 *     V1: Método simples na interface
 *     V2-V3: Adição de ID de transação
 *     V4: Retorno Future + callbacks
 *     Original: Completação assíncrona com métricas
 * 2. Gerenciamento de Threads
 *     V2: Thread pool fixo
 *     V3: Tamanho configurável
 *     V4: WorkStealingPool
 *     Original: Pool personalizado baseado em CPUs
 * 3. Geração de IDs
 *     V3: Simples (timestamp + contador)
 *     Original: Mais robusto (node ID + timestamp + contador atômico)
 * 4. Tratamento de Resultados
 *     V1-3: Nenhum/Void
 *     V4: Callbacks simples
 *     Original: Sistema completo de callbacks + métricas
 * Esta estrutura permite começar com algo simples e entender cada componente antes de adicionar complexidade. Cada versão introduz novos conceitos de forma incremental.
 */
