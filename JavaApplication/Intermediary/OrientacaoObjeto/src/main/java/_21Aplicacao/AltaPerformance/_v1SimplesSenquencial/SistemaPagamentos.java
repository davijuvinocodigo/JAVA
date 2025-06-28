package _21Aplicacao.AltaPerformance._v1SimplesSenquencial;

// Versão 1: Básica (Sem concorrência, sem padrões avançados)

class DadosCartao {
    private String numero;
    private String dataValidade;
    private String cvv;

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
    private DadosCartao dados;

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
    private String chave;

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
        DadosCartao cartao = new DadosCartao("1234567890123456", "12/25", "123");
        MetodoPagamento pagamento1 = new CartaoCredito(cartao);
        MetodoPagamento pagamento2 = new Pix("chave@exemplo.com");

        pagamento1.processarPagamento(100.50);
        pagamento2.processarPagamento(200.75);
    }
}

/**
 * Versão 1: Básica (Sequencial)
 * Componentes principais:
 *     DadosCartao: Classe simples para armazenar dados do cartão
 *     MetodoPagamento: Interface básica com método processarPagamento
 *     Implementações concretas (CartaoCredito e Pix)
 *     Classe principal que instancia e usa os métodos
 * Características:
 *     Totalmente sequencial
 *     Sem tratamento de concorrência
 *     Sem identificação de transações
 *     Simples e direto para entender o fluxo básico
 */
