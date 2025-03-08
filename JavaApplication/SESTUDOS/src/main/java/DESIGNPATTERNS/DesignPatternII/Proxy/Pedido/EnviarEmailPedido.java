package DESIGNPATTERNS.DesignPatternII.Proxy.Pedido;

public class EnviarEmailPedido implements AcaoPedido {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Enviando email com dados do pedido!!");
    }
}
