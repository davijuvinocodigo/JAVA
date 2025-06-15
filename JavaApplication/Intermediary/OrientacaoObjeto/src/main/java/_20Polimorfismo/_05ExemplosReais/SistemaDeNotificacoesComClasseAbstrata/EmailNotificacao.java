package _20Polimorfismo._05ExemplosReais.SistemaDeNotificacoesComClasseAbstrata;

class EmailNotificacao extends Notificacao {
    public EmailNotificacao() {
        super("E-mail");
    }

    @Override
    public void enviar(String destinatario, String mensagem) {
        preProcessarMensagem(mensagem);
        System.out.println("Enviando e-mail para: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
        registrarEnvio();
    }

    @Override
    protected void preProcessarMensagem(String mensagem) {
        System.out.println("Adicionando cabeçalho HTML ao e-mail");
    }
}
