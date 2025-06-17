package _20Polimorfismo._03ClassesFinal;

import java.util.ArrayList;
import java.util.List;

// Interface para as notificações (não pode ser final)
interface Notificavel {
    void enviar();
    String getDestinatario();
}

// Classes de notificação (algumas serão finais)
final class NotificacaoEmail implements Notificavel {
    private final String email;
    private final String mensagem;

    public NotificacaoEmail(String email, String mensagem) {
        this.email = email;
        this.mensagem = mensagem;
    }

    @Override
    public void enviar() {
        System.out.println("[EMAIL] Para: " + email);
        System.out.println("Mensagem: " + mensagem);
    }

    @Override
    public String getDestinatario() {
        return email;
    }

    // Método específico da classe final
    public void adicionarAssunto(String assunto) {
        System.out.println("Assunto do e-mail: " + assunto);
    }
}

final class NotificacaoSMS implements Notificavel {
    private final String telefone;
    private final String mensagem;

    public NotificacaoSMS(String telefone, String mensagem) {
        this.telefone = telefone;
        this.mensagem = mensagem;
    }

    @Override
    public void enviar() {
        System.out.println("[SMS] Para: " + telefone);
        System.out.println("Texto: " + mensagem);
    }

    @Override
    public String getDestinatario() {
        return telefone;
    }
}

// Classe final que não pode ser estendida
final class NotificadorFinal {
    // Método polimórfico que trabalha com a interface
    public void enviarNotificacao(Notificavel notificacao) {
        System.out.println("\nIniciando envio para: " + notificacao.getDestinatario());
        notificacao.enviar();

        // Verificação do tipo para métodos específicos
        if (notificacao instanceof NotificacaoEmail) {
            ((NotificacaoEmail) notificacao).adicionarAssunto("Notificação do sistema");
        }

        System.out.println("Envio concluído!");
    }

    // Método para enviar uma lista de notificações
    public void enviarTodas(List<? extends Notificavel> notificacoes) {
        System.out.println("\n=== ENVIANDO LOTE DE NOTIFICAÇÕES ===");
        for (Notificavel notificacao : notificacoes) {
            enviarNotificacao(notificacao);
            System.out.println("---");
        }
    }

    // Método utilitário final
    public final void relatorioEnvios(List<? extends Notificavel> notificacoes) {
        System.out.println("\n=== RELATÓRIO ===");
        System.out.println("Total de notificações: " + notificacoes.size());

        long emails = notificacoes.stream().filter(n -> n instanceof NotificacaoEmail).count();
        long sms = notificacoes.stream().filter(n -> n instanceof NotificacaoSMS).count();

        System.out.println("E-mails: " + emails);
        System.out.println("SMS: " + sms);
    }
}

// Classe principal
public class SistemaNotificacaoFinal {
    public static void main(String[] args) {
        // Criando o notificador final
        NotificadorFinal notificador = new NotificadorFinal();

        // Criando notificações (classes finais)
        Notificavel email1 = new NotificacaoEmail("cliente@exemplo.com", "Bem-vindo ao nosso serviço");
        Notificavel email2 = new NotificacaoEmail("suporte@empresa.com", "Sua solicitação foi atendida");
        Notificavel sms1 = new NotificacaoSMS("+5511987654321", "Seu código de verificação é 1234");

        // Lista de notificações
        List<Notificavel> notificacoes = new ArrayList<>();
        notificacoes.add(email1);
        notificacoes.add(email2);
        notificacoes.add(sms1);

        // Envio individual
        System.out.println("=== ENVIO INDIVIDUAL ===");
        notificador.enviarNotificacao(email1);

        // Envio em lote
        notificador.enviarTodas(notificacoes);

        // Relatório
        notificador.relatorioEnvios(notificacoes);

        // Tentativa de criar uma subclasse (gera erro de compilação)
        // class NotificadorEspecial extends NotificadorFinal {} // Erro: Cannot inherit from final NotificadorFinal
    }
}

/**
 * Características Principais
 *     Classes Final:
 *         NotificadorFinal: Classe utilitária que não pode ser estendida
 *         NotificacaoEmail e NotificacaoSMS: Classes finais de implementação concreta
 *     Polimorfismo:
 *         Mantido através da interface Notificavel
 *         O NotificadorFinal trabalha com qualquer implementação da interface
 *     Métodos Final:
 *         relatorioEnvios é um método final que não pode ser sobrescrito
 *     Imutabilidade:
 *         Campos das classes finais são marcados como final quando apropriado
 */


/**
 * Benefícios desta Abordagem
 *     Segurança:
 *         Classes finais previnem modificações não intencionais através de herança
 *         Garante que o comportamento crítico não seja alterado
 *     Performance:
 *         Métodos de classes finais podem ser otimizados pelo compilador
 *     Design Intencional:
 *         Deixa claro quais classes foram projetadas para não serem estendidas
 *     Polimorfismo Mantido:
 *         Ainda podemos usar diferentes implementações através da interface
 */

/**
 * Quando Usar Classes Final
 *     Classes utilitárias que não devem ser estendidas
 *     Classes imutáveis onde a herança poderia comprometer a imutabilidade
 *     Classes de segurança onde o comportamento não deve ser modificado
 *     Classes de implementação concreta quando você quer evitar especializações
 * Esta abordagem combina os benefícios do polimorfismo (através da interface) com a segurança e restrições das classes finais, demonstrando como esses conceitos podem trabalhar juntos em um design robusto.
 */
