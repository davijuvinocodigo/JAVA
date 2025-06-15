package _20Polimorfismo._05ExemplosReais.SistemaDeNotificacoesComClasseAbstrata;


public class Main {
    public static void main(String[] args) {
        SistemaNotificacoes sistema = new SistemaNotificacoes();
        sistema.adicionarCanal(new EmailNotificacao());
        sistema.adicionarCanal(new SMSNotificacao());
        sistema.notificarTodos("cliente@exemplo.com", "Seu pedido foi enviado!");
    }
}
