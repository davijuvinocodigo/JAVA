package _21Aplicacao.Concorrencia;

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
 * Funcionamento Básico:
 *     Métodos de Pagamento:
 *         Cada método (CartaoCredito, Pix) implementa a interface MetodoPagamento
 *         O método pagar() retorna um CompletableFuture<Boolean>
 *     Processamento Concorrente:
 *         ProcessadorPagamentos gerencia um pool de threads
 *         O método processar() executa todos os pagamentos em paralelo
 *     Simplicidade:
 *         Foco apenas no fluxo principal (sem tratamentos complexos de erro)
 *         Código enxuto e fácil de entender
 */
