package _19Interfaces._03AtributosMetodosEstaticos;

import java.util.List;

// Interface para notificações rastreáveis
public interface Rastreavel {
    String getStatus(String idNotificacao);
    List<String> getHistorico(String idNotificacao);

    // Status possíveis como constantes estáticas
    String STATUS_ENVIADO = "ENVIADO";
    String STATUS_ENTREGUE = "ENTREGUE";
    String STATUS_FALHA = "FALHA";
}
