package _19Interfaces._02ImplementandoMultiplasInterfaces;


import java.time.LocalDateTime;

public class NotificacaoSMS implements Notificavel, Agendavel {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Enviando SMS para: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
    }

    @Override
    public void agendar(String destinatario, String mensagem, LocalDateTime dataHora) {
        System.out.println("SMS agendado para: " + dataHora);
        System.out.println("Destinatário: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
    }
}
