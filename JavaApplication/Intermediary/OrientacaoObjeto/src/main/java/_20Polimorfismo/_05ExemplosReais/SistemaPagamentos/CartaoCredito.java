package _20Polimorfismo._05ExemplosReais.SistemaPagamentos;

public class CartaoCredito implements MetodoPagamento {
    private String numero;
    private String cvv;

    public CartaoCredito(String numero, String cvv) {
        this.numero = numero;
        this.cvv = cvv;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando R$" + valor + " via cartão de crédito " + numero.substring(12));
    }

    @Override
    public boolean validar() {
        return numero.length() == 16 && cvv.length() == 3;
    }
}
