package _19Interfaces._02ImplementandoMultiplasInterfaces;

import java.time.LocalDateTime;
import java.util.*;


// Interface para notificações que podem ser agendadas
interface Agendavel {
    void agendar(String destinatario, String mensagem, LocalDateTime dataHora);
}


// Interface para notificações que suportam templates
interface ComTemplate {
    void setTemplate(String template);
    String getTemplate();
}


// Interface básica para envio de notificações
interface Notificavel {
    void enviar(String destinatario, String mensagem);
}


// Interface para notificações rastreáveis
interface Rastreavel {
    String getStatus(String idNotificacao);
    List<String> getHistorico(String idNotificacao);
}






class NotificacaoEmail implements Notificavel, ComTemplate, Rastreavel {
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







class NotificacaoPush implements Notificavel, Agendavel, ComTemplate, Rastreavel {
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






class NotificacaoSMS implements Notificavel, Agendavel {
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






class GerenciadorNotificacoesAvancado {
    private Notificavel notificacao;

    public GerenciadorNotificacoesAvancado(Notificavel notificacao) {
        this.notificacao = notificacao;
    }

    public void enviarNotificacao(String destinatario, String mensagem) {
        notificacao.enviar(destinatario, mensagem);

        // Se for rastreável, mostra o status
        if (notificacao instanceof Rastreavel) {
            System.out.println("Status: " + ((Rastreavel) notificacao).getStatus("ultimo"));
        }
    }

    public void agendarNotificacao(String destinatario, String mensagem, LocalDateTime dataHora) {
        if (notificacao instanceof Agendavel) {
            ((Agendavel) notificacao).agendar(destinatario, mensagem, dataHora);
        } else {
            System.out.println("Este tipo de notificação não suporta agendamento");
        }
    }

    public void setTemplate(String template) {
        if (notificacao instanceof ComTemplate) {
            ((ComTemplate) notificacao).setTemplate(template);
        } else {
            System.out.println("Este tipo de notificação não suporta templates");
        }
    }

    public void mostrarHistorico() {
        if (notificacao instanceof Rastreavel) {
            System.out.println("Histórico: " + ((Rastreavel) notificacao).getHistorico("ultimo"));
        }
    }

    public void setNotificacao(Notificavel notificacao) {
        this.notificacao = notificacao;
    }
}




public class ImplementandoMultiplasInterfaces {
    public static void main(String[] args) {
        // Criando instâncias
        NotificacaoEmail email = new NotificacaoEmail();
        NotificacaoSMS sms = new NotificacaoSMS();
        NotificacaoPush push = new NotificacaoPush();

        // Configurando gerenciador com notificação por email
        GerenciadorNotificacoesAvancado gerenciador = new GerenciadorNotificacoesAvancado(email);

        // Usando template
        gerenciador.setTemplate("Prezado usuário, {mensagem}. Atenciosamente, Equipe.");
        gerenciador.enviarNotificacao("cliente@email.com", "seu pedido foi processado");
        gerenciador.mostrarHistorico();

        // Mudando para SMS (que não suporta template)
        gerenciador.setNotificacao(sms);
        gerenciador.setTemplate("Template não suportado"); // Vai mostrar mensagem de não suportado
        gerenciador.enviarNotificacao("(11) 99999-9999", "Seu código é 1234");

        // Agendando SMS
        gerenciador.agendarNotificacao("(11) 98888-8888", "Lembrete: reunião amanhã",
                LocalDateTime.now().plusDays(1));

        // Mudando para Push (que suporta tudo)
        gerenciador.setNotificacao(push);
        gerenciador.setTemplate("Notificação: {mensagem}");
        gerenciador.enviarNotificacao("user123", "Novas mensagens disponíveis");
        gerenciador.agendarNotificacao("user123", "Promoção especial",
                LocalDateTime.now().plusHours(6));
        gerenciador.mostrarHistorico();
    }
}


/**
 *
 * Vantagens deste Design com Múltiplas Interfaces
 *     Segregação de Interfaces: Cada interface tem uma responsabilidade única
 *     Flexibilidade: Classes podem implementar apenas as interfaces que precisam
 *     Extensibilidade: Novas funcionalidades podem ser adicionadas via novas interfaces
 *     Polimorfismo: Podemos tratar objetos diferentes de maneira uniforme quando compartilham interfaces
 *     Manutenibilidade: Fácil de modificar ou estender sem afetar outras partes do sistema
 * Este exemplo demonstra como usar múltiplas interfaces para criar um sistema mais robusto e flexível, onde cada tipo de notificação pode ter capacidades diferentes enquanto mantém uma base comum.
 */
