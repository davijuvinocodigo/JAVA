package _19Interfaces._03AtributosMetodosEstaticos;

import java.time.LocalDateTime;

public class NotificacaoSMS extends NotificacaoBase implements Notificavel, Agendavel {
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
