package _05SobrecargaMetodos;


class Mensagem {
    // Versão básica
    public void enviar(String destinatario, String texto) {
        System.out.println("Enviando para " + destinatario + ": " + texto);
    }

    // Sobrecarga com prioridade
    public void enviar(String destinatario, String texto, boolean urgente) {
        String prefixo = urgente ? "[URGENTE] " : "";
        System.out.println(prefixo + "Enviando para " + destinatario + ": " + texto);
    }

    // Sobrecarga para múltiplos destinatários
    public void enviar(String[] destinatarios, String texto) {
        for (String dest : destinatarios) {
            enviar(dest, texto);  // Reusa a versão básica
        }
    }

    // Sobrecarga com objeto Email
    public void enviar(Email email) {
        enviar(email.getDestinatario(), email.getTexto(), email.isUrgente());
    }
}

class Email {
    private String destinatario;
    private String texto;
    private boolean urgente;

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }
}


public class Sobrecarga {
    public static void main(String[] args) {
        Mensagem mensagem = new Mensagem();

        // Enviar mensagem básica
        mensagem.enviar("João", "Olá, tudo bem?");

        // Enviar mensagem urgente
        mensagem.enviar("Maria", "Preciso falar com você!", true);

        // Enviar mensagem para múltiplos destinatários
        String[] destinatarios = {"Carlos", "Ana", "Pedro"};
        mensagem.enviar(destinatarios, "Reunião marcada para amanhã às 10h.");

        // Enviar mensagem com objeto Email
        Email email = new Email();
        email.setDestinatario("Lucas");
        email.setTexto("Favor enviar os relatórios até o final do dia.");
        email.setUrgente(true);
        mensagem.enviar(email);
    }
}
