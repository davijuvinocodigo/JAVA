package _19Interfaces._03AtributosMetodosEstaticos;

import java.time.LocalDateTime;

public class GerenciadorNotificacoesAvancado {
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
