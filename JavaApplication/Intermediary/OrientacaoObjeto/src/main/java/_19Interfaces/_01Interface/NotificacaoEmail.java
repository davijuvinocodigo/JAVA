package _19Interfaces._01Interface;

public class NotificacaoEmail implements Notificacao {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Enviando email para: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
        // Lógica real para enviar email
    }
}
