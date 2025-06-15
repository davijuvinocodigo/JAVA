package _20Polimorfismo._05ExemplosReais.SistemaDeNotificacoes;

public class EmailNotificacao implements Notificacao {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Enviando e-mail para: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
    }
}
