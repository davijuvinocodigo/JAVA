package _19Interfaces._01Conceito;



// Interface que define o contrato para todas as notificações
interface Notificacao {
    void enviar(String destinatario, String mensagem);
}



class NotificacaoEmail implements Notificacao {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Enviando email para: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
        // Lógica real para enviar email
    }
}



class NotificacaoSMS implements Notificacao {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Enviando SMS para: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
        // Lógica real para enviar SMS
    }
}




class NotificacaoPush implements Notificacao {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Enviando notificação push para: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
        // Lógica real para enviar push
    }
}




class GerenciadorNotificacoes {
    private Notificacao notificacao;

    // Injeção de dependência via construtor
    public GerenciadorNotificacoes(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    // Método para enviar notificação
    public void enviarNotificacao(String destinatario, String mensagem) {
        notificacao.enviar(destinatario, mensagem);
    }

    // Método para alterar o tipo de notificação em tempo de execução
    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }
}




public class Conceito {
    public static void main(String[] args) {
        // Criando os tipos de notificação
        Notificacao email = new NotificacaoEmail();
        Notificacao sms = new NotificacaoSMS();
        Notificacao push = new NotificacaoPush();

        // Criando o gerenciador com notificação por email
        GerenciadorNotificacoes gerenciador = new GerenciadorNotificacoes(email);

        // Enviando notificação por email
        gerenciador.enviarNotificacao("cliente@email.com", "Seu pedido foi enviado!");

        // Mudando para SMS e enviando
        gerenciador.setNotificacao(sms);
        gerenciador.enviarNotificacao("(11) 99999-9999", "Seu pedido está a caminho!");

        // Mudando para push e enviando
        gerenciador.setNotificacao(push);
        gerenciador.enviarNotificacao("user123", "Seu pedido chegou!");
    }
}


/**
 *
 * Benefícios deste Design
 *     Flexibilidade: Podemos adicionar novos tipos de notificação sem modificar o código existente.
 *     Baixo acoplamento: O GerenciadorNotificacoes não conhece os detalhes de implementação das notificações.
 *     Extensibilidade: Fácil de adicionar novos canais de notificação.
 *     Testabilidade: Fácil de testar com mocks/stubs.
 * Este é um exemplo básico que pode ser expandido com mais funcionalidades como:
 *     Tratamento de erros
 *     Notificações assíncronas
 *     Templates de mensagem
 *     Configurações específicas para cada canal
 */
