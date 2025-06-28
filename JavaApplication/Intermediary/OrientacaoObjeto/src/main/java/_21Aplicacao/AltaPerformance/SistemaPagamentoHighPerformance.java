package _21Aplicacao.AltaPerformance;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

// 1. OBJETOS IMUTÁVEIS PARA THREAD-SAFETY
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

// 2. INTERFACE FUNCIONAL PARA PAGAMENTO (HIGH-PERFORMANCE)
@FunctionalInterface
interface PagamentoHandler {
    void processar(double valor, String idTransacao);

    default String obterDetalhes() {
        return this.getClass().getSimpleName();
    }
}

// 3. CACHE DE OBJETOS FREQUENTES (FLYWEIGHT PATTERN)
class PagamentoHandlerCache {
    private static final ConcurrentMap<String, PagamentoHandler> cache = new ConcurrentHashMap<>();

    static {
        // Pré-carrega handlers comuns
        cache.put("PIX", new PixHandler("chave.padrao@pix.com"));
        cache.put("BOLETO", new BoletoHandler("00000000000000000000"));
    }

    public static PagamentoHandler getHandler(String tipo, Supplier<PagamentoHandler> supplier) {
        return cache.computeIfAbsent(tipo, k -> supplier.get());
    }
}

// 4. HANDLERS OTIMIZADOS (SEM SYNCHRONIZED, COM PADROES DE MEMORIA)
class CartaoHandler implements PagamentoHandler {
    private static final AtomicInteger counter = new AtomicInteger();
    private final DadosCartao dados;
    private final int instanceId = counter.incrementAndGet();

    public CartaoHandler(DadosCartao dados) {
        this.dados = dados;
    }

    @Override
    public void processar(double valor, String idTransacao) {
        String maskedNumero = dados.getNumero().substring(0, 4) + " **** **** ****";
        System.out.printf("[%s] Processando cartão %s - R$%.2f%n",
                idTransacao, maskedNumero, valor);
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

class BoletoHandler implements PagamentoHandler {
    private final String codigoBarras;

    public BoletoHandler(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void processar(double valor, String idTransacao) {
        System.out.printf("[%s] Processando boleto %s - R$%.2f%n",
                idTransacao, codigoBarras.substring(0, 5), valor);
    }

    @Override
    public String obterDetalhes() {
        return "Boleto - " + codigoBarras.substring(0, 5) + "...";
    }
}

// 5. THREAD POOL PERSONALIZADO (WORK STEALING)
class PagamentoExecutor {
    private static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static final int MAX_POOL_SIZE = CORE_POOL_SIZE * 4;
    private static final int QUEUE_CAPACITY = 1000;
    private static final long KEEP_ALIVE_TIME = 60L;

    private final ExecutorService executor;
    private final AtomicLong tasksProcessed = new AtomicLong();
    private final LongAdder rejectedTasks = new LongAdder();

    public PagamentoExecutor() {
        this.executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

    public CompletableFuture<Void> processarAsync(PagamentoHandler handler,
                                                  double valor,
                                                  String idTransacao) {
        CompletableFuture<Void> future = new CompletableFuture<>();

        try {
            executor.execute(() -> {
                try {
                    handler.processar(valor, idTransacao);
                    tasksProcessed.incrementAndGet();
                    future.complete(null);
                } catch (Exception e) {
                    future.completeExceptionally(e);
                }
            });
        } catch (RejectedExecutionException e) {
            rejectedTasks.increment();
            future.completeExceptionally(e);
        }

        return future;
    }

    public void shutdown() throws InterruptedException {
        executor.shutdown();
        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }

    public long getTasksProcessed() { return tasksProcessed.get(); }
    public long getRejectedTasks() { return rejectedTasks.sum(); }
}

// 6. GERADOR DE IDs DE TRANSACAO PERFORMATICO
class TransactionIdGenerator {
    private static final AtomicLong counter = new AtomicLong();
    private static final String NODE_ID = Integer.toHexString(
            ThreadLocalRandom.current().nextInt());

    public static String generateId() {
        long timestamp = System.currentTimeMillis();
        long count = counter.incrementAndGet();
        return String.format("%s-%x-%d", NODE_ID, timestamp, count);
    }
}

// 7. BATCH PROCESSING PARA PAGAMENTOS
class PagamentoBatchProcessor {
    private final PagamentoExecutor executor;
    private final int batchSize;
    private final Consumer<PagamentoHandler> callback;

    public PagamentoBatchProcessor(PagamentoExecutor executor,
                                   int batchSize,
                                   Consumer<PagamentoHandler> callback) {
        this.executor = executor;
        this.batchSize = batchSize;
        this.callback = callback;
    }

    public void processBatch(PagamentoHandler handler, double[] valores) {
        int total = valores.length;
        int batches = (total + batchSize - 1) / batchSize;

        for (int i = 0; i < batches; i++) {
            int start = i * batchSize;
            int end = Math.min(start + batchSize, total);

            for (int j = start; j < end; j++) {
                String id = TransactionIdGenerator.generateId();
                executor.processarAsync(handler, valores[j], id)
                        .thenRun(() -> callback.accept(handler));
            }
        }
    }
}

// 8. CLASSE PRINCIPAL OTIMIZADA
public class SistemaPagamentoHighPerformance {
    public static void main(String[] args) throws InterruptedException {
        // Configuração inicial
        PagamentoExecutor executor = new PagamentoExecutor();
        PagamentoHandlerCache cache = new PagamentoHandlerCache();

        // Criação de handlers (com cache)
        PagamentoHandler cartao = cache.getHandler("CARTAO",
                () -> new CartaoHandler(new DadosCartao("1234567890123456", "12/25", "123")));

        PagamentoHandler pix = cache.getHandler("PIX",
                () -> new PixHandler("chave.pix@exemplo.com"));

        PagamentoHandler boleto = cache.getHandler("BOLETO",
                () -> new BoletoHandler("34191790010104351004791020150008700000000000000"));

        // Callback de conclusão
        Consumer<PagamentoHandler> callback = handler ->
                System.out.println("Callback: " + handler.obterDetalhes());

        // Processamento em batch
        PagamentoBatchProcessor batchProcessor = new PagamentoBatchProcessor(executor, 100, callback);

        // Gerar valores aleatórios para teste
        double[] valores = ThreadLocalRandom.current().doubles(500, 10, 1000).toArray();

        // Processar pagamentos em paralelo
        batchProcessor.processBatch(cartao, valores);
        batchProcessor.processBatch(pix, valores);
        batchProcessor.processBatch(boleto, valores);

        // Aguardar conclusão
        Thread.sleep(2000);
        executor.shutdown();

        // Métricas
        System.out.printf("\nMétricas:%nProcessados: %d%nRejeitados: %d%n",
                executor.getTasksProcessed(),
                executor.getRejectedTasks());
    }
}


/**
 * Técnicas de Alta Performance Aplicadas:
 *     Imutabilidade:
 *         Objetos imutáveis (DadosCartao) para thread-safety sem sincronização
 *         Elimina necessidade de locks em operações de leitura
 *     Cache de Objetos (Flyweight):
 *         Reutilização de handlers frequentes
 *         Reduz alocação de objetos e garbage collection
 *     Concorrência Avançada:
 *         ExecutorService personalizado com tamanho ótimo de pool
 *         CompletableFuture para programação assíncrona
 *         LongAdder para contadores concorrentes de alta performance
 *     Padrões de Memória:
 *         Uso de AtomicInteger e AtomicLong para contadores
 *         Objetos pequenos e alinhados para melhor cache locality
 *     Processamento em Batch:
 *         Agrupamento de transações para melhor throughput
 *         Redução de overhead por operação
 *     Geração Eficiente de IDs:
 *         IDs de transação otimizados com timestamp e contador atômico
 *         Formato compacto para redução de memória
 *     Avoiding Blocking:
 *         Política de rejeição explícita para evitar bloqueio
 *         Métricas de rejeição para monitoramento
 *     Estruturas de Dados Concorrentes:
 *         ConcurrentHashMap para cache thread-safe
 *         LinkedBlockingQueue com capacidade limitada
 * Benefícios de Performance:
 *     Throughput aumentado: Processamento paralelo de até 4x núcleos disponíveis
 *     Latência reduzida: Operações não-bloqueantes e assíncronas
 *     Eficiência de memória: Cache de objetos e imutabilidade reduzem GC
 *     Escalabilidade: Design adequado para alta carga
 *     Resiliência: Tratamento adequado de sobrecarga
 * Esta implementação é adequada para sistemas que precisam processar milhares de transações por segundo com baixa latência e alto throughput.
 */
