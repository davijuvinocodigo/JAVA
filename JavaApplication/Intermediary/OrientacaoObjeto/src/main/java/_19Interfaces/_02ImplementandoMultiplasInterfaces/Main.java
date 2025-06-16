package _19Interfaces._02ImplementandoMultiplasInterfaces;

import java.time.LocalDateTime;

public class Main {
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
