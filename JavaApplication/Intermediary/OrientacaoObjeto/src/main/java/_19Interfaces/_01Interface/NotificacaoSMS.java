package _19Interfaces._01Interface;

public class NotificacaoSMS implements Notificacao {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Enviando SMS para: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
        // Lógica real para enviar SMS
    }
}
