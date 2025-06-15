package _20Polimorfismo._05ExemplosReais.SistemaDeNotificacoesComClasseAbstrata;

import java.util.Date;

public abstract class Notificacao {
    protected String formato;

    public Notificacao(String formato) {
        this.formato = formato;
    }

    public abstract void enviar(String destinatario, String mensagem);

    // Método concreto compartilhado
    protected void registrarEnvio() {
        System.out.println("Registrando envio no formato " + formato + " em " + new Date());
    }

    // Método hook (opcional para subclasses)
    protected void preProcessarMensagem(String mensagem) {
        // Implementação padrão vazia
    }
}
