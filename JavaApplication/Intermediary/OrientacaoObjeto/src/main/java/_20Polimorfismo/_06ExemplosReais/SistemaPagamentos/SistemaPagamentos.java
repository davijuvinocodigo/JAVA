package _20Polimorfismo._06ExemplosReais.SistemaPagamentos;


interface MetodoPagamento {
    void processarPagamento(double valor);
    boolean validar();
}





class Pix implements MetodoPagamento {
    private String chave;

    public Pix(String chave) {
        this.chave = chave;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando R$" + valor + " via PIX para chave " + chave);
    }

    @Override
    public boolean validar() {
        return chave != null && !chave.isEmpty();
    }
}





class CartaoCredito implements MetodoPagamento {
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





class SistemaPagamento {
    public void realizarPagamento(MetodoPagamento metodo, double valor) {
        if (metodo.validar()) {
            metodo.processarPagamento(valor);
        } else {
            System.out.println("Método de pagamento inválido!");
        }
    }
}




public class SistemaPagamentos {
    public static void main(String[] args) {
        SistemaPagamento sistema = new SistemaPagamento();

        MetodoPagamento cartao = new CartaoCredito("1234567812345678", "123");
        sistema.realizarPagamento(cartao, 150.50);

        MetodoPagamento pix = new Pix("email@exemplo.com");
        sistema.realizarPagamento(pix, 200.75);
    }
}
