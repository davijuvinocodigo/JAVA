package _19Interfaces._01Interface;

public class GerenciadorNotificacoes {
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
