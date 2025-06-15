package _20Polimorfismo._05ExemplosReais.SistemaPagamentos;

public class Main {
    public static void main(String[] args) {
        SistemaPagamento sistema = new SistemaPagamento();

        MetodoPagamento cartao = new CartaoCredito("1234567812345678", "123");
        sistema.realizarPagamento(cartao, 150.50);

        MetodoPagamento pix = new Pix("email@exemplo.com");
        sistema.realizarPagamento(pix, 200.75);
    }
}
