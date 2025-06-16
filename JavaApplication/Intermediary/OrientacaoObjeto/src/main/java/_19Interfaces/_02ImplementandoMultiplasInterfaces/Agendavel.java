package _19Interfaces._02ImplementandoMultiplasInterfaces;

import java.time.LocalDateTime;

// Interface para notificações que podem ser agendadas
public interface Agendavel {
    void agendar(String destinatario, String mensagem, LocalDateTime dataHora);
}
