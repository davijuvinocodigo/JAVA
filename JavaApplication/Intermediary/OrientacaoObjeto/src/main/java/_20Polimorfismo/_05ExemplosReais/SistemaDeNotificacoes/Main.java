package _20Polimorfismo._05ExemplosReais.SistemaDeNotificacoes;

public class Main {
    public static void main(String[] args) {
        SistemaNotificacoes sistema = new SistemaNotificacoes();
        sistema.adicionarCanal(new EmailNotificacao());
        sistema.adicionarCanal(new SMSNotificacao());
        sistema.adicionarCanal(new PushNotificacao());

        sistema.notificarTodos("cliente@exemplo.com", "Seu pedido foi enviado!");
    }
}
