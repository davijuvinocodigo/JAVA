package _20Polimorfismo._06ExemplosReais.SistemaPagamentosComClasseAbstrata;

public class Pix extends MetodoPagamento {
    public Pix(String chave) {
        super(chave);
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando R$" + valor + " via PIX para chave " + identificacao);
        registrarTransacao(valor);
    }
}
