package _21Aplicacao.Concorrencia._v2ConcorrenciaSimples;

import java.util.concurrent.*;
import java.util.*;

interface MetodoPagamento {
    CompletableFuture<Boolean> pagar(double valor);
}

class CartaoCredito implements MetodoPagamento {
    private final String numero;

    public CartaoCredito(String numero) {
        this.numero = numero;
    }

    @Override
    public CompletableFuture<Boolean> pagar(double valor) {
        return CompletableFuture.supplyAsync(() -> {
            // Simula processamento demorado
            try { Thread.sleep(100); }
            catch (InterruptedException e) { return false; }

            System.out.println("Pagamento com cartão " + numero.substring(12) + ": R$" + valor);
            return new Random().nextDouble() > 0.1; // 90% de sucesso
        });
    }
}

class Pix implements MetodoPagamento {
    private final String chave;

    public Pix(String chave) {
        this.chave = chave;
    }

    @Override
    public CompletableFuture<Boolean> pagar(double valor) {
        return CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(50); }
            catch (InterruptedException e) { return false; }

            System.out.println("Pagamento PIX " + chave.substring(0, 5) + "...: R$" + valor);
            return new Random().nextDouble() > 0.05; // 95% de sucesso
        });
    }
}

class ProcessadorPagamentos {
    private final ExecutorService executor;

    public ProcessadorPagamentos(int threads) {
        this.executor = Executors.newFixedThreadPool(threads);
    }

    public CompletableFuture<Void> processar(List<MetodoPagamento> pagamentos, double valor) {
        List<CompletableFuture<Boolean>> resultados = new ArrayList<>();

        for (MetodoPagamento metodo : pagamentos) {
            resultados.add(metodo.pagar(valor));
        }

        return CompletableFuture.allOf(resultados.toArray(new CompletableFuture[0]));
    }

    public void shutdown() {
        executor.shutdown();
    }
}

public class SistemaPagamentoSimples {
    public static void main(String[] args) throws Exception {
        // Configuração
        ProcessadorPagamentos processador = new ProcessadorPagamentos(4);

        // Cria métodos de pagamento
        List<MetodoPagamento> pagamentos = Arrays.asList(
                new CartaoCredito("1111222233334444"),
                new Pix("chave.pix@exemplo.com"),
                new CartaoCredito("5555666677778888"),
                new Pix("11987654321")
        );

        // Processa pagamentos de R$100.00
        CompletableFuture<Void> processamento = processador.processar(pagamentos, 100.00);

        // Aguarda conclusão
        processamento.get();
        System.out.println("Todos os pagamentos foram processados!");

        // Encerra
        processador.shutdown();
    }
}


/**
 * Estrutura Principal:
 *     MetodoPagamento: Interface que define o contrato para todos os métodos de pagamento
 *     CartaoCredito e Pix: Implementações concretas da interface
 *     ProcessadorPagamentos: Classe que gerencia o processamento paralelo
 *     SistemaPagamentoSimples: Classe principal com método main
 * Fluxo de Execução:
 *     O sistema cria um processador com pool de 4 threads
 *     Configura 4 métodos de pagamento (2 cartões e 2 PIX)
 *     Inicia o processamento assíncrono de todos
 *     Aguarda a conclusão com processamento.get()
 *     Finaliza o processador
 * Detalhes Importantes:
 *     Thread.sleep: Simula o tempo de processamento (100ms para cartão, 50ms para PIX)
 *     Random().nextDouble(): Gera sucesso aleatório (90% cartão, 95% PIX)
 *     CompletableFuture: Permite execução assíncrona e não-bloqueante
 *     allOf(): Combina vários Futures em um só que completa quando todos terminam
 */

/**
 *     Pontos Chave:
 *         Paralelismo: Pagamentos são processados simultaneamente
 *         Flexibilidade: Fácil adição de novos métodos de pagamento
 *         Controle: Shutdown adequado do pool de threads
 *         Assincronia: Não bloqueia a thread principal durante o processamento
 * O sistema demonstra um padrão comum em aplicações financeiras, onde múltiplas operações podem ser processadas em paralelo com diferentes características para cada método de pagamento.
 */
