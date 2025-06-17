package _20Polimorfismo._06ExemplosReais.SistemaPagamentosComClasseAbstrata;

public abstract class MetodoPagamento {
    protected String identificacao;

    public MetodoPagamento(String identificacao) {
        this.identificacao = identificacao;
    }

    // Método abstrato (deve ser implementado pelas subclasses)
    public abstract void processarPagamento(double valor);

    // Método concreto com implementação padrão
    public boolean validar() {
        return identificacao != null && !identificacao.isEmpty();
    }

    // Outro método concreto
    public void registrarTransacao(double valor) {
        System.out.println("Registrando transação de R$" + valor);
    }
}
