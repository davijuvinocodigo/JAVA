package _20Polimorfismo._05ExemplosReais.SistemaPagamentos;

public interface MetodoPagamento {
    void processarPagamento(double valor);
    boolean validar();
}
