package _19Interfaces._03AtributosMetodosEstaticos;

// Interface básica para envio de notificações
public interface Notificavel {
    void enviar(String destinatario, String mensagem);

    // Método estático para validar email
    static boolean validarEmail(String email) {
        return email != null && email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
