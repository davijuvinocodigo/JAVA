package _20Polimorfismo._05ExemplosReais.SistemaPagamentos;

public class SistemaPagamento {
    public void realizarPagamento(MetodoPagamento metodo, double valor) {
        if (metodo.validar()) {
            metodo.processarPagamento(valor);
        } else {
            System.out.println("Método de pagamento inválido!");
        }
    }
}
