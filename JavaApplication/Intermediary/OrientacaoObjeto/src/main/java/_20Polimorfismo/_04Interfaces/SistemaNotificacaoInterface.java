package _20Polimorfismo._04Interfaces;

import java.util.ArrayList;
import java.util.List;

// Interface principal para notificações
interface Notificacao {
    void enviar();
    String getMensagem();
    void setMensagem(String mensagem);
}

// Interface para notificações que suportam prioridade
interface NotificacaoPrioritaria {
    void setPrioridade(int nivel);
    int getPrioridade();
}

// Implementação de notificação por e-mail
class NotificacaoEmail implements Notificacao {
    private String destinatario;
    private String mensagem;
    private String assunto;

    public NotificacaoEmail(String destinatario, String assunto) {
        this.destinatario = destinatario;
        this.assunto = assunto;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando e-mail para: " + destinatario);
        System.out.println("Assunto: " + assunto);
        System.out.println("Mensagem: " + mensagem);
    }

    @Override
    public String getMensagem() {
        return mensagem;
    }

    @Override
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void adicionarAnexo(String nomeArquivo) {
        System.out.println("Anexando arquivo: " + nomeArquivo);
    }
}

// Implementação de notificação por SMS
class NotificacaoSMS implements Notificacao {
    private String numero;
    private String mensagem;

    public NotificacaoSMS(String numero) {
        this.numero = numero;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando SMS para: " + numero);
        System.out.println("Mensagem: " + mensagem);
    }

    @Override
    public String getMensagem() {
        return mensagem;
    }

    @Override
    public void setMensagem(String mensagem) {
        if (mensagem.length() > 160) {
            System.out.println("Aviso: SMS truncado para 160 caracteres");
            this.mensagem = mensagem.substring(0, 160);
        } else {
            this.mensagem = mensagem;
        }
    }
}

// Implementação de notificação push com prioridade
class NotificacaoPush implements Notificacao, NotificacaoPrioritaria {
    private String dispositivoId;
    private String mensagem;
    private int prioridade;

    public NotificacaoPush(String dispositivoId) {
        this.dispositivoId = dispositivoId;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando push para: " + dispositivoId);
        System.out.println("Prioridade: " + prioridade);
        System.out.println("Mensagem: " + mensagem);
    }

    @Override
    public String getMensagem() {
        return mensagem;
    }

    @Override
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public void setPrioridade(int nivel) {
        if (nivel < 1 || nivel > 5) {
            throw new IllegalArgumentException("Prioridade deve ser entre 1 e 5");
        }
        this.prioridade = nivel;
    }

    @Override
    public int getPrioridade() {
        return prioridade;
    }
}

// Gerenciador de notificações que trabalha com a interface
class GerenciadorNotificacoes {
    public void enviarTodas(List<Notificacao> notificacoes) {
        System.out.println("\n=== ENVIANDO NOTIFICAÇÕES ===");
        for (Notificacao notificacao : notificacoes) {
            notificacao.enviar();
            System.out.println("---");
        }
    }

    public void configurarNotificacoesPrioritarias(List<Notificacao> notificacoes, int prioridade) {
        for (Notificacao notificacao : notificacoes) {
            if (notificacao instanceof NotificacaoPrioritaria) {
                ((NotificacaoPrioritaria) notificacao).setPrioridade(prioridade);
            }
        }
    }
}

// Classe principal
public class SistemaNotificacaoInterface {
    public static void main(String[] args) {
        // Criando o gerenciador
        GerenciadorNotificacoes gerenciador = new GerenciadorNotificacoes();

        // Criando notificações
        Notificacao email = new NotificacaoEmail("cliente@exemplo.com", "Atualização de conta");
        email.setMensagem("Sua conta foi atualizada com sucesso.");

        Notificacao sms = new NotificacaoSMS("+5511999999999");
        sms.setMensagem("Seu código de verificação é 123456. Por favor, não compartilhe este código com ninguém.");

        NotificacaoPush push = new NotificacaoPush("device-xyz-123");
        push.setMensagem("Você tem uma nova mensagem");
        push.setPrioridade(3);

        // Lista de notificações
        List<Notificacao> notificacoes = new ArrayList<>();
        notificacoes.add(email);
        notificacoes.add(sms);
        notificacoes.add(push);

        // Enviando notificações
        gerenciador.enviarTodas(notificacoes);

        // Configurando prioridades
        System.out.println("\nConfigurando prioridades...");
        gerenciador.configurarNotificacoesPrioritarias(notificacoes, 5);

        // Enviando novamente com prioridades atualizadas
        gerenciador.enviarTodas(notificacoes);

        // Demonstração de polimorfismo
        System.out.println("\n=== DEMONSTRAÇÃO DE POLIMORFISMO ===");
        Notificacao[] arrayNotificacoes = {email, sms, push};
        for (Notificacao notificacao : arrayNotificacoes) {
            System.out.println("Tipo: " + notificacao.getClass().getSimpleName());
            System.out.println("Mensagem: " + notificacao.getMensagem());
            System.out.println("---");
        }
    }
}

/**
 * Características Principais
 *     Interfaces:
 *         Notificacao: Interface principal com métodos básicos
 *         NotificacaoPrioritaria: Interface adicional para funcionalidade extra
 *     Implementações:
 *         NotificacaoEmail: Implementação para e-mails
 *         NotificacaoSMS: Implementação para mensagens SMS
 *         NotificacaoPush: Implementa ambas as interfaces
 *     Polimorfismo:
 *         O GerenciadorNotificacoes trabalha apenas com a interface base
 *         Cada classe implementa os métodos de forma diferente
 *     Extensibilidade:
 *         Novos tipos de notificação podem ser adicionados sem modificar o gerenciador
 *         Novas interfaces podem ser criadas para funcionalidades adicionais
 * Benefícios desta Abordagem
 *     Baixo acoplamento: O gerenciador não conhece as implementações concretas
 *     Alta coesão: Cada classe tem responsabilidades bem definidas
 *     Extensibilidade fácil: Novos tipos de notificação podem ser adicionados
 *     Polimorfismo eficiente: Mesmo código trabalha com diferentes implementações
 */


/**
 * Quando Usar Interfaces
 *     Quando você precisa definir um contrato comum para classes não relacionadas
 *     Para permitir que uma classe implemente múltiplos comportamentos
 *     Quando você quer separar a definção do comportamento da implementação
 *     Para criar sistemas com baixo acoplamento e alta extensibilidade
 * Este exemplo demonstra como as interfaces permitem um design flexível e polimórfico, onde diferentes tipos de notificações podem ser tratadas de maneira uniforme, enquanto cada uma mantém sua implementação específica.
 */
