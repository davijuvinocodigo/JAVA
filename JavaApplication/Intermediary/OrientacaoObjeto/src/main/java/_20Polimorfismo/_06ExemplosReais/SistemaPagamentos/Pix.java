package _20Polimorfismo._06ExemplosReais.SistemaPagamentos;

public class Pix implements MetodoPagamento {
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

