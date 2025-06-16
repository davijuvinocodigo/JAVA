package _19Interfaces._03AtributosMetodosEstaticos;

import java.text.SimpleDateFormat;

public abstract class NotificacaoBase {
    // Contador estático de notificações enviadas
    protected static int totalNotificacoesEnviadas = 0;

    // Método estático para obter contagem total
    public static int getTotalNotificacoesEnviadas() {
        return totalNotificacoesEnviadas;
    }

    // Método estático para resetar contador (apenas para testes)
    protected static void resetarContador() {
        totalNotificacoesEnviadas = 0;
    }

    // Atributo estático compartilhado
    protected static final SimpleDateFormat FORMATADOR_DATA =
            new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
}
