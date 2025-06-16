package _19Interfaces._03AtributosMetodosEstaticos;

import java.time.LocalDateTime;

public class Main {
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
