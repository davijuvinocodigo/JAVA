package _20Polimorfismo._06ExemplosReais.SistemaPagamentos;

public interface MetodoPagamento {
    void processarPagamento(double valor);
    boolean validar();
}
