package _20Polimorfismo._05ExemplosReais.SistemaDeNotificacoes;

public class SMSNotificacao implements Notificacao {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Enviando SMS para: " + destinatario);
        System.out.println("Texto: " + mensagem.substring(0, Math.min(mensagem.length(), 160)));
    }
}
