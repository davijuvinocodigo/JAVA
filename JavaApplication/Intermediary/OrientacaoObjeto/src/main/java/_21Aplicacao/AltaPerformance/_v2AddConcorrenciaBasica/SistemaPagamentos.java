package _21Aplicacao.AltaPerformance._v2AddConcorrenciaBasica;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Versão com processamento concorrente básico

class DadosCartao {
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

interface MetodoPagamento {
    void processarPagamento(double valor);
}

class CartaoCredito implements MetodoPagamento {
    private final DadosCartao dados;

    public CartaoCredito(DadosCartao dados) {
        this.dados = dados;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via cartão " +
                dados.getNumero().substring(0, 4) + "****");
    }
}

class Pix implements MetodoPagamento {
    private final String chave;

    public Pix(String chave) {
        this.chave = chave;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via PIX para " + chave);
    }
}

class SistemaPagamentos {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        DadosCartao cartao = new DadosCartao("1234567890123456", "12/25", "123");
        MetodoPagamento pagamento1 = new CartaoCredito(cartao);
        MetodoPagamento pagamento2 = new Pix("chave@exemplo.com");

        executor.execute(() -> pagamento1.processarPagamento(100.50));
        executor.execute(() -> pagamento2.processarPagamento(200.75));
        executor.execute(() -> pagamento1.processarPagamento(50.25));

        executor.shutdown();
    }
}


/**
 * Versão 2: Concorrência Básica
 * Melhorias adicionadas:
 *     Uso de ExecutorService para processamento paralelo
 *     Thread pool fixo com 3 threads
 *     Processamento assíncrono via executor.execute()
 *     Shutdown do executor para finalização correta
 * Pontos importantes:
 *     Introduz conceitos básicos de programação concorrente
 *     Ainda sem tratamento de resultados ou erros
 *     Simples mas funcional para casos básicos
 */
