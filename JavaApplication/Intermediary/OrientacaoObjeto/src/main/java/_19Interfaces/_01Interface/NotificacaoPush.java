package _19Interfaces._01Interface;

public class NotificacaoPush implements Notificacao {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Enviando notificação push para: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
        // Lógica real para enviar push
    }
}
