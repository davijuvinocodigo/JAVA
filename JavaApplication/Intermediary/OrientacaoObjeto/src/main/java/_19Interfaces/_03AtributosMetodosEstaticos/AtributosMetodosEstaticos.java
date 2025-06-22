package _19Interfaces._03AtributosMetodosEstaticos;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;


// Interface básica para envio de notificações
interface Notificavel {
    void enviar(String destinatario, String mensagem);

    // Método estático para validar email
    static boolean validarEmail(String email) {
        return email != null && email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}




// Interface para notificações rastreáveis
interface Rastreavel {
    String getStatus(String idNotificacao);
    List<String> getHistorico(String idNotificacao);

    // Status possíveis como constantes estáticas
    String STATUS_ENVIADO = "ENVIADO";
    String STATUS_ENTREGUE = "ENTREGUE";
    String STATUS_FALHA = "FALHA";
}




// Interface para notificações que podem ser agendadas
interface Agendavel {
    void agendar(String destinatario, String mensagem, LocalDateTime dataHora);

    // Método estático para calcular diferença até o agendamento
    static long minutosParaAgendamento(LocalDateTime dataHora) {
        return ChronoUnit.MINUTES.between(LocalDateTime.now(), dataHora);
    }
}



// Interface para notificações que suportam templates
interface ComTemplate {
    void setTemplate(String template);
    String getTemplate();

    // Template padrão como constante estática
    String TEMPLATE_PADRAO = "Mensagem: {mensagem}";
}




abstract class NotificacaoBase {
    // Contador estático de notificações enviadas
    protected static int totalNotificacoesEnviadas = 0;

    // Método estático para obter contagem total
    public static int getTotalNotificacoesEnviadas() {
        return totalNotificacoesEnviadas;
    }

    // Método estático para resetar contador (apenas para testes)
    protected static void resetarContador() {
        totalNotificacoesEnviadas = 0;
    }

    // Atributo estático compartilhado
    protected static final SimpleDateFormat FORMATADOR_DATA =
            new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
}




class NotificacaoEmail extends NotificacaoBase implements Notificavel, ComTemplate, Rastreavel {
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





class NotificacaoSMS extends NotificacaoBase implements Notificavel, Agendavel {
    // Custo por SMS (atributo estático)
    private static double CUSTO_POR_SMS = 0.10;
    private static double custoTotal = 0.0;

    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Enviando SMS para: " + destinatario);
        System.out.println("Mensagem: " + mensagem);

        // Registrar custo
        custoTotal += CUSTO_POR_SMS;
        totalNotificacoesEnviadas++;
    }

    @Override
    public void agendar(String destinatario, String mensagem, LocalDateTime dataHora) {
        long minutos = Agendavel.minutosParaAgendamento(dataHora);
        System.out.println("SMS agendado para daqui a " + minutos + " minutos");
        System.out.println("Destinatário: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
    }

    // Métodos estáticos para gerenciar custos
    public static void setCustoPorSMS(double novoCusto) {
        CUSTO_POR_SMS = novoCusto;
    }

    public static double getCustoTotal() {
        return custoTotal;
    }

    public static void zerarCustoTotal() {
        custoTotal = 0.0;
    }
}






class GerenciadorNotificacoesAvancado {
    private Notificavel notificacao;

    // Contador estático de instâncias
    private static int instanciasAtivas = 0;

    public GerenciadorNotificacoesAvancado(Notificavel notificacao) {
        this.notificacao = notificacao;
        instanciasAtivas++;
    }

    // Métodos de instância anteriores...
    public void enviarNotificacao(String destinatario, String mensagem) {
        if (notificacao instanceof Notificavel) {
            // Usando método estático da interface para validar email se aplicável
            if (notificacao instanceof NotificacaoEmail &&
                    !Notificavel.validarEmail(destinatario)) {
                System.out.println("Email inválido!");
                return;
            }

            notificacao.enviar(destinatario, mensagem);

            if (notificacao instanceof Rastreavel) {
                System.out.println("Status: " + ((Rastreavel) notificacao).getStatus("ultimo"));
            }
        }
    }

    // Método estático para obter instâncias ativas
    public static int getInstanciasAtivas() {
        return instanciasAtivas;
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





public class AtributosMetodosEstaticos {
    public static void main(String[] args) {
        // Demonstrando métodos e atributos estáticos

        // Configurar limite de emails
        NotificacaoEmail.setLimiteDiario(3);

        // Configurar custo de SMS
        NotificacaoSMS.setCustoPorSMS(0.15);

        // Criar gerenciadores
        GerenciadorNotificacoesAvancado g1 = new GerenciadorNotificacoesAvancado(new NotificacaoEmail());
        GerenciadorNotificacoesAvancado g2 = new GerenciadorNotificacoesAvancado(new NotificacaoSMS());

        System.out.println("Gerenciadores ativos: " + GerenciadorNotificacoesAvancado.getInstanciasAtivas());

        // Usar template padrão da interface
        g1.setTemplate(ComTemplate.TEMPLATE_PADRAO);
        g1.enviarNotificacao("cliente@email.com", "Teste de mensagem");

        // Enviar SMS
        g2.enviarNotificacao("(11) 99999-9999", "Mensagem SMS");
        g2.agendarNotificacao("(11) 98888-8888", "Lembrete", LocalDateTime.now().plusHours(2));

        System.out.println("Total de notificações enviadas: " + NotificacaoBase.getTotalNotificacoesEnviadas());
        System.out.println("Uso de emails: " + NotificacaoEmail.getUsoDiario());
        System.out.println("Custo total de SMS: R$" + NotificacaoSMS.getCustoTotal());

        // Tentar enviar além do limite
        try {
            for (int i = 0; i < 5; i++) {
                g1.enviarNotificacao("outro@email.com", "Mensagem " + i);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}


/**
 * Principais Características Demonstradas
 *     Atributos Estáticos:
 *         totalNotificacoesEnviadas para contar todas as notificações
 *         LIMITE_DIARIO e emailsHoje para controle de limites
 *         CUSTO_POR_SMS e custoTotal para cálculo de custos
 *     Métodos Estáticos:
 *         validarEmail() na interface Notificavel
 *         minutosParaAgendamento() na interface Agendavel
 *         setLimiteDiario() e getUsoDiario() na classe NotificacaoEmail
 *         getInstanciasAtivas() no gerenciador
 *     Constantes Estáticas:
 *         TEMPLATE_PADRAO na interface ComTemplate
 *         Status na interface Rastreavel
 *         FORMATADOR_DATA na classe base
 *     Padrões Úteis:
 *         Controle de estado compartilhado entre instâncias
 *         Métodos utilitários associados à classe
 *         Constantes de configuração
 *         Contadores globais
 * Este design mostra como usar efetivamente elementos estáticos em um sistema OO, mantendo uma boa organização e aproveitando os benefícios tanto da orientação a objetos quanto da programação estruturada quando apropriado.
 */
