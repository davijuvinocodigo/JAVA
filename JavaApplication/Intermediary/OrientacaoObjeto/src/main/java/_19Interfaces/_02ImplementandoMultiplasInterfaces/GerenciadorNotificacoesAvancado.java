package _19Interfaces._02ImplementandoMultiplasInterfaces;

import java.time.LocalDateTime;

public class GerenciadorNotificacoesAvancado {
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
