package DESIGNPATTERNS.DesignPatternI.Observer.Pedido;

public class EnviarEmailPedido implements Acao {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Enviando email com dados do pedido!!");
    }
}
