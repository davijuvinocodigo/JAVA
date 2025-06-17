package _20Polimorfismo._01Conceito;

import java.util.ArrayList;
import java.util.List;

// Interface comum para todas as notificações
interface Notificavel {
    void enviarNotificacao();
    String getMensagem();
}

// Classes concretas de notificação
class NotificacaoEmail implements Notificavel {
    private String email;
    private String mensagem;

    public NotificacaoEmail(String email, String mensagem) {
        this.email = email;
        this.mensagem = mensagem;
    }

    @Override
    public void enviarNotificacao() {
        System.out.println("Enviando e-mail para: " + email);
        System.out.println("Mensagem: " + mensagem);
        // Lógica real de envio de e-mail iria aqui
    }

    @Override
    public String getMensagem() {
        return mensagem;
    }
}

class NotificacaoSMS implements Notificavel {
    private String telefone;
    private String mensagem;

    public NotificacaoSMS(String telefone, String mensagem) {
        this.telefone = telefone;
        this.mensagem = mensagem;
    }

    @Override
    public void enviarNotificacao() {
        System.out.println("Enviando SMS para: " + telefone);
        System.out.println("Mensagem: " + mensagem);
        // Lógica real de envio de SMS iria aqui
    }

    @Override
    public String getMensagem() {
        return mensagem;
    }
}

class NotificacaoPush implements Notificavel {
    private String dispositivoId;
    private String mensagem;

    public NotificacaoPush(String dispositivoId, String mensagem) {
        this.dispositivoId = dispositivoId;
        this.mensagem = mensagem;
    }

    @Override
    public void enviarNotificacao() {
        System.out.println("Enviando notificação push para dispositivo: " + dispositivoId);
        System.out.println("Mensagem: " + mensagem);
        // Lógica real de envio de push notification iria aqui
    }

    @Override
    public String getMensagem() {
        return mensagem;
    }
}

// Classe que gerencia as notificações
class GerenciadorNotificacoes {
    public void enviarTodas(List<Notificavel> notificacoes) {
        for (Notificavel notificacao : notificacoes) {
            notificacao.enviarNotificacao();
            System.out.println("---");
        }
    }

    // Método polimórfico que funciona com qualquer Notificavel
    public void enviarNotificacao(Notificavel notificacao) {
        System.out.println("Preparando para enviar notificação...");
        notificacao.enviarNotificacao();
        System.out.println("Notificação enviada com sucesso!\n");
    }
}

// Classe principal para demonstração
public class SistemaNotificacao {
    public static void main(String[] args) {
        // Criando o gerenciador
        GerenciadorNotificacoes gerenciador = new GerenciadorNotificacoes();

        // Criando diferentes tipos de notificações
        Notificavel email = new NotificacaoEmail("cliente@email.com", "Seu pedido foi enviado!");
        Notificavel sms = new NotificacaoSMS("+5511999999999", "Lembrete: consulta médica amanhã");
        Notificavel push = new NotificacaoPush("device12345", "Você tem uma nova mensagem");

        // Usando polimorfismo - o mesmo método funciona para diferentes tipos
        System.out.println("Enviando notificações individualmente:");
        gerenciador.enviarNotificacao(email);
        gerenciador.enviarNotificacao(sms);
        gerenciador.enviarNotificacao(push);

        // Usando polimorfismo com uma lista de notificações
        System.out.println("\nEnviando todas as notificações:");
        List<Notificavel> todasNotificacoes = new ArrayList<>();
        todasNotificacoes.add(email);
        todasNotificacoes.add(sms);
        todasNotificacoes.add(push);

        gerenciador.enviarTodas(todasNotificacoes);

        // Demonstração adicional de polimorfismo
        System.out.println("\nMensagens das notificações:");
        mostrarMensagens(todasNotificacoes);
    }

    // Método que demonstra polimorfismo
    public static void mostrarMensagens(List<Notificavel> notificacoes) {
        for (Notificavel notificacao : notificacoes) {
            System.out.println("Tipo: " + notificacao.getClass().getSimpleName());
            System.out.println("Conteúdo: " + notificacao.getMensagem());
            System.out.println("---");
        }
    }
}


/**
 * Como o Polimorfismo é Aplicado
 *     Interface comum: Todas as classes implementam Notificavel, garantindo que tenham os métodos enviarNotificacao() e getMensagem().
 *     Métodos polimórficos:
 *         O GerenciadorNotificacoes pode enviar qualquer tipo de notificação sem saber sua classe concreta
 *         O método enviarTodas() trabalha com a interface Notificavel, não com implementações específicas
 *     Comportamento específico:
 *         Cada tipo de notificação (Email, SMS, Push) implementa enviarNotificacao() de forma diferente
 *         Quando chamado, o método correto é invocado baseado no tipo real do objeto
 * Benefícios Demonstrados
 *     Extensibilidade: Pode-se adicionar novos tipos de notificação sem modificar o GerenciadorNotificacoes
 *     Manutenibilidade: O código que usa as notificações não precisa saber sobre os detalhes de implementação
 *     Reutilização: A lógica de envio é centralizada e pode ser aplicada a qualquer notificação
 */

