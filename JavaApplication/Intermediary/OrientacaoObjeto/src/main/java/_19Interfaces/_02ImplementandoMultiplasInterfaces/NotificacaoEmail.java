package _19Interfaces._02ImplementandoMultiplasInterfaces;

import java.time.LocalDateTime;
import java.util.*;

public class NotificacaoEmail implements Notificavel, ComTemplate, Rastreavel {
    private String template;
    private Map<String, List<String>> historico = new HashMap<>();

    @Override
    public void enviar(String destinatario, String mensagem) {
        String id = UUID.randomUUID().toString();
        System.out.println("Enviando email para: " + destinatario);
        System.out.println("Mensagem: " + (template != null ? template.replace("{mensagem}", mensagem) : mensagem));

        // Registrar no histórico
        List<String> eventos = new ArrayList<>();
        eventos.add("Enviado em: " + LocalDateTime.now());
        historico.put(id, eventos);
    }

    @Override
    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public String getTemplate() {
        return template;
    }

    @Override
    public String getStatus(String idNotificacao) {
        return historico.containsKey(idNotificacao) ? "ENTREGUE" : "NÃO ENCONTRADO";
    }

    @Override
    public List<String> getHistorico(String idNotificacao) {
        return historico.getOrDefault(idNotificacao, Collections.emptyList());
    }
}
