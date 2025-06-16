package _19Interfaces._03AtributosMetodosEstaticos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class NotificacaoEmail extends NotificacaoBase implements Notificavel, ComTemplate, Rastreavel {
    private String template;
    private Map<String, List<String>> historico = new HashMap<>();

    // Limite diário de emails (atributo estático)
    private static int LIMITE_DIARIO = 1000;
    private static int emailsHoje = 0;
    private static LocalDate ultimoDia = LocalDate.now();

    @Override
    public void enviar(String destinatario, String mensagem) {
        // Verificar limite diário
        verificarLimiteDiario();

        String id = UUID.randomUUID().toString();
        System.out.println("Enviando email para: " + destinatario);
        System.out.println("Mensagem: " + (template != null ? template.replace("{mensagem}", mensagem) : mensagem));

        // Registrar no histórico
        List<String> eventos = new ArrayList<>();
        eventos.add("Enviado em: " + LocalDateTime.now());
        historico.put(id, eventos);

        // Incrementar contadores
        emailsHoje++;
        totalNotificacoesEnviadas++;
    }

    private void verificarLimiteDiario() {
        LocalDate hoje = LocalDate.now();
        if (!hoje.equals(ultimoDia)) {
            ultimoDia = hoje;
            emailsHoje = 0;
        }

        if (emailsHoje >= LIMITE_DIARIO) {
            throw new IllegalStateException("Limite diário de emails atingido!");
        }
    }

    // Método estático para configurar limite diário
    public static void setLimiteDiario(int novoLimite) {
        LIMITE_DIARIO = novoLimite;
    }

    // Método estático para verificar uso diário
    public static String getUsoDiario() {
        return emailsHoje + "/" + LIMITE_DIARIO + " emails enviados hoje";
    }

    // Restante dos métodos da interface...
    @Override
    public void setTemplate(String template) { this.template = template; }

    @Override
    public String getTemplate() { return template; }

    @Override
    public String getStatus(String idNotificacao) {
        return historico.containsKey(idNotificacao) ? Rastreavel.STATUS_ENTREGUE : "NÃO ENCONTRADO";
    }

    @Override
    public List<String> getHistorico(String idNotificacao) {
        return historico.getOrDefault(idNotificacao, Collections.emptyList());
    }
}
