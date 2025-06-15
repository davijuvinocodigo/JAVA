package _20Polimorfismo._05ExemplosReais.SistemaDeNotificacoes;

import java.util.ArrayList;
import java.util.List;

public class SistemaNotificacoes {
    private List<Notificacao> canais = new ArrayList<>();

    public void adicionarCanal(Notificacao canal) {
        canais.add(canal);
    }

    public void notificarTodos(String destinatario, String mensagem) {
        for (Notificacao canal : canais) {
            canal.enviar(destinatario, mensagem);
            System.out.println("---");
        }
    }
}
