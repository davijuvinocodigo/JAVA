package _21Aplicacao.AltaPerformance._v3OrganizacaoImutabilidade;

import java.util.concurrent.*;
import java.util.function.Consumer;

// Versão com padrões intermediários e melhor organização

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
}

class CartaoHandler implements PagamentoHandler {
    private final DadosCartao dados;

    public CartaoHandler(DadosCartao dados) {
        this.dados = dados;
    }

    @Override
    public void processar(double valor, String idTransacao) {
        System.out.printf("[%s] Processando cartão %s - R$%.2f%n",
                idTransacao, dados.getNumero().substring(0, 4) + "****", valor);
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
}

class PagamentoExecutor {
    private final ExecutorService executor;

    public PagamentoExecutor(int poolSize) {
        this.executor = Executors.newFixedThreadPool(poolSize);
    }

    public void processarAsync(PagamentoHandler handler, double valor, String idTransacao) {
        executor.execute(() -> handler.processar(valor, idTransacao));
    }

    public void shutdown() throws InterruptedException {
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
    }
}

public class SistemaPagamento {
    public static void main(String[] args) throws InterruptedException {
        PagamentoExecutor executor = new PagamentoExecutor(4);

        DadosCartao cartao = new DadosCartao("1234567890123456", "12/25", "123");
        PagamentoHandler cartaoHandler = new CartaoHandler(cartao);
        PagamentoHandler pixHandler = new PixHandler("chave@exemplo.com");

        for (int i = 0; i < 10; i++) {
            String id = "TX" + System.currentTimeMillis() + "-" + i;
            double valor = 100 + (i * 10);

            if (i % 2 == 0) {
                executor.processarAsync(cartaoHandler, valor, id);
            } else {
                executor.processarAsync(pixHandler, valor, id);
            }
        }

        executor.shutdown();
    }
}

/**
 * Versão 3: Padrões Intermediários
 * Novos conceitos introduzidos:
 *     Objetos imutáveis (final em DadosCartao)
 *     Interface PagamentoHandler mais completa
 *     PagamentoExecutor como wrapper do ExecutorService
 *     IDs de transação para rastreamento
 *     Melhor organização do código
 * Melhorias:
 *     Mais seguro para uso concorrente (imutabilidade)
 *     Melhor estruturação do código
 *     Preparação para extensão
 *     Controle básico do ciclo de vida do executor
 */
