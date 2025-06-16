package _19Interfaces._01Interface;

public class Main {
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
