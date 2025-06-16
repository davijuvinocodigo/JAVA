package _19Interfaces._02ImplementandoMultiplasInterfaces;


import java.time.LocalDateTime;
import java.util.*;

public class NotificacaoPush implements Notificavel, Agendavel, ComTemplate, Rastreavel {
    private String template;
    private Map<String, List<String>> historico = new HashMap<>();

    @Override
    public void enviar(String destinatario, String mensagem) {
        String id = UUID.randomUUID().toString();
        System.out.println("Enviando push para: " + destinatario);
        System.out.println("Mensagem: " + (template != null ? template.replace("{mensagem}", mensagem) : mensagem));

        List<String> eventos = new ArrayList<>();
        eventos.add("Enviado em: " + LocalDateTime.now());
        historico.put(id, eventos);
    }

    @Override
    public void agendar(String destinatario, String mensagem, LocalDateTime dataHora) {
        String id = UUID.randomUUID().toString();
        System.out.println("Push agendado para: " + dataHora);

        List<String> eventos = new ArrayList<>();
        eventos.add("Agendado em: " + LocalDateTime.now() + " para " + dataHora);
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
        return historico.containsKey(idNotificacao) ? "PROCESSANDO" : "NÃO ENCONTRADO";
    }

    @Override
    public List<String> getHistorico(String idNotificacao) {
        return historico.getOrDefault(idNotificacao, Collections.emptyList());
    }
}
