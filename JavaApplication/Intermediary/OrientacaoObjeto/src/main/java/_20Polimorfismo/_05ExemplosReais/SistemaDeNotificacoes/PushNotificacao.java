package _20Polimorfismo._05ExemplosReais.SistemaDeNotificacoes;

public
class PushNotificacao implements Notificacao {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Enviando push para dispositivo: " + destinatario);
        System.out.println("Notificação: " + mensagem);
    }
}
