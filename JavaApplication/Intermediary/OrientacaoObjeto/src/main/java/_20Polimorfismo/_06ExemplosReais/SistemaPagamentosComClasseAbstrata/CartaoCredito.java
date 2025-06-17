package _20Polimorfismo._06ExemplosReais.SistemaPagamentosComClasseAbstrata;

public class CartaoCredito extends MetodoPagamento {
    private String cvv;

    public CartaoCredito(String numero, String cvv) {
        super(numero);
        this.cvv = cvv;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando R$" + valor + " via cartão de crédito " + identificacao.substring(12));
        registrarTransacao(valor);
    }

    @Override
    public boolean validar() {
        return super.validar() && identificacao.length() == 16 && cvv.length() == 3;
    }
}
