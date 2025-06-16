package _19Interfaces._02ImplementandoMultiplasInterfaces;

import java.util.List;

// Interface para notificações rastreáveis
public interface Rastreavel {
    String getStatus(String idNotificacao);
    List<String> getHistorico(String idNotificacao);
}
