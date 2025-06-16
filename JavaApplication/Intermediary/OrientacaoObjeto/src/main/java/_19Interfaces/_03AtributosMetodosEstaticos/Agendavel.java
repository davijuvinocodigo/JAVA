package _19Interfaces._03AtributosMetodosEstaticos;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

// Interface para notificações que podem ser agendadas
public interface Agendavel {
    void agendar(String destinatario, String mensagem, LocalDateTime dataHora);

    // Método estático para calcular diferença até o agendamento
    static long minutosParaAgendamento(LocalDateTime dataHora) {
        return ChronoUnit.MINUTES.between(LocalDateTime.now(), dataHora);
    }
}
