package _21Aplicacao.Generico;


// Interface genérica que define o contrato para todas as formas de pagamento
interface FormaPagamento<T> {
    void processarPagamento(double valor);
    String obterDetalhes();
    T getDadosPagamento(); // Método adicional para retornar os dados específicos
}

// Classe para pagamento com cartão de crédito
class CartaoCredito implements FormaPagamento<CartaoCredito.DadosCartao> {
    private DadosCartao dados;

    // Classe interna para representar os dados do cartão
    static class DadosCartao {
        String numero;
        String dataValidade;
        String cvv;

        public DadosCartao(String numero, String dataValidade, String cvv) {
            this.numero = numero;
            this.dataValidade = dataValidade;
            this.cvv = cvv;
        }
    }

    public CartaoCredito(String numero, String dataValidade, String cvv) {
        this.dados = new DadosCartao(numero, dataValidade, cvv);
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Cartão de Crédito");
        System.out.println("Número: " + dados.numero.substring(0, 4) + " **** **** ****");
    }

    @Override
    public String obterDetalhes() {
        return "Cartão de Crédito - Final " + dados.numero.substring(dados.numero.length() - 4);
    }

    @Override
    public DadosCartao getDadosPagamento() {
        return dados;
    }
}

// Classe para pagamento com PIX
class Pix implements FormaPagamento<String> {
    private String chave;

    public Pix(String chave) {
        this.chave = chave;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via PIX");
        System.out.println("Chave: " + chave);
    }

    @Override
    public String obterDetalhes() {
        return "PIX - Chave: " + (chave.length() > 10 ? chave.substring(0, 10) + "..." : chave);
    }

    @Override
    public String getDadosPagamento() {
        return chave;
    }
}

// Classe para pagamento com boleto bancário
class BoletoBancario implements FormaPagamento<String> {
    private String codigoBarras;

    public BoletoBancario(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Boleto Bancário");
        System.out.println("Código de Barras: " + codigoBarras);
    }

    @Override
    public String obterDetalhes() {
        return "Boleto - " + codigoBarras.substring(0, 5) + "...";
    }

    @Override
    public String getDadosPagamento() {
        return codigoBarras;
    }
}

// Classe genérica que representa um pagamento
class Pagamento<T> {
    private double valor;
    private FormaPagamento<T> formaPagamento;

    public Pagamento(double valor, FormaPagamento<T> formaPagamento) {
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public void processarPagamento() {
        System.out.println("\nIniciando pagamento...");
        System.out.println("Forma: " + formaPagamento.obterDetalhes());
        formaPagamento.processarPagamento(this.valor);
        System.out.println("Dados completos: " + formaPagamento.getDadosPagamento());
        System.out.println("Pagamento concluído!");
    }
}

// Classe principal para testar o sistema
public class SistemaPagamentoGenerico {
    public static void main(String[] args) {
        // Criando formas de pagamento
        FormaPagamento<CartaoCredito.DadosCartao> cartao =
                new CartaoCredito("1234 5678 9012 3456", "12/25", "123");
        FormaPagamento<String> pix = new Pix("chave.pix@exemplo.com");
        FormaPagamento<String> boleto =
                new BoletoBancario("34191.79001 01043.510047 91020.150008 7 00000000000000");

        // Criando pagamentos com tipos específicos
        Pagamento<CartaoCredito.DadosCartao> pagamento1 = new Pagamento<>(150.50, cartao);
        Pagamento<String> pagamento2 = new Pagamento<>(89.90, pix);
        Pagamento<String> pagamento3 = new Pagamento<>(1200.00, boleto);

        // Processando pagamentos
        pagamento1.processarPagamento();
        pagamento2.processarPagamento();
        pagamento3.processarPagamento();
    }
}


/**
 * Melhorias realizadas:
 *     Interface Genérica: Transformei FormaPagamento em uma interface genérica FormaPagamento<T>, onde T representa o tipo dos dados específicos de pagamento.
 *     Método adicional: Adicionei o método getDadosPagamento() que retorna os dados específicos do tipo T.
 *     Classe interna para dados do cartão: Criei uma classe interna DadosCartao para encapsular melhor os dados do cartão de crédito.
 *     Pagamento genérico: A classe Pagamento agora é genérica e recebe o tipo correspondente à forma de pagamento.
 *     Type safety: O uso de generics garante que os tipos sejam verificados em tempo de compilação, evitando erros de runtime.
 *     Encapsulamento: Os dados específicos de cada forma de pagamento estão melhor encapsulados.
 * Esta abordagem com generics torna o código mais seguro, flexível e expressivo, mantendo todas as vantagens da versão original com interfaces, mas com um controle de tipos mais rigoroso.
 */
