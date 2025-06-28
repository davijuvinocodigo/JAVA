package _21Aplicacao;


// Classe abstrata que representa uma forma de pagamento genérica
abstract class FormaPagamento {
    public abstract void processarPagamento(double valor);
}

// Classe para pagamento com cartão de crédito
class CartaoCredito extends FormaPagamento {
    private String numero;
    private String dataValidade;
    private String cvv;

    public CartaoCredito(String numero, String dataValidade, String cvv) {
        this.numero = numero;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Cartão de Crédito");
        System.out.println("Número: " + numero.substring(0, 4) + " **** **** ****");
        // Lógica para processar o pagamento com cartão
    }
}

// Classe para pagamento com PIX
class Pix extends FormaPagamento {
    private String chave;

    public Pix(String chave) {
        this.chave = chave;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via PIX");
        System.out.println("Chave: " + chave);
        // Lógica para processar o pagamento com PIX
    }
}

// Classe para pagamento com boleto bancário
class BoletoBancario extends FormaPagamento {
    private String codigoBarras;

    public BoletoBancario(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Boleto Bancário");
        System.out.println("Código de Barras: " + codigoBarras);
        // Lógica para processar o pagamento com boleto
    }
}

// Classe que representa um pagamento
class Pagamento {
    private double valor;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public void processarPagamento(FormaPagamento formaPagamento) {
        formaPagamento.processarPagamento(this.valor);
    }
}


// Classe principal que representa o sistema de pagamento
public class SistemaPagamento {
    public static void main(String[] args) {
        // Criando formas de pagamento
        FormaPagamento cartaoCredito = new CartaoCredito("1234 5678 9012 3456", "12/25", "123");
        FormaPagamento pix = new Pix("chave@email.com");
        FormaPagamento boleto = new BoletoBancario("34191.79001 01043.510047 91020.150008 7 00000000000000");

        // Criando um pagamento
        Pagamento pagamento = new Pagamento(150.50);

        // Processando pagamentos com diferentes formas
        pagamento.processarPagamento(cartaoCredito);
        pagamento.processarPagamento(pix);
        pagamento.processarPagamento(boleto);
    }
}


/**
 * Conceitos de Orientação a Objetos utilizados:
 *     Abstração: A classe abstrata FormaPagamento define um contrato para todas as formas de pagamento.
 *     Herança: As classes CartaoCredito, Pix e BoletoBancario herdam de FormaPagamento.
 *     Polimorfismo: O método processarPagamento() se comporta de maneira diferente em cada classe concreta.
 *     Encapsulamento: Os atributos das classes são privados e acessados apenas através de métodos.
 */
