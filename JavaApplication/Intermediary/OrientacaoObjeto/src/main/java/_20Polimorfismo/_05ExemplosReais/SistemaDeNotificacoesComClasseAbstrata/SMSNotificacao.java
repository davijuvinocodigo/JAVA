package _20Polimorfismo._05ExemplosReais.SistemaDeNotificacoesComClasseAbstrata;

public class SMSNotificacao extends Notificacao {
    public SMSNotificacao() {
        super("SMS");
    }

    @Override
    public void enviar(String destinatario, String mensagem) {
        String mensagemLimitada = mensagem.substring(0, Math.min(mensagem.length(), 160));
        System.out.println("Enviando SMS para: " + destinatario);
        System.out.println("Texto: " + mensagemLimitada);
        registrarEnvio();
    }
}
