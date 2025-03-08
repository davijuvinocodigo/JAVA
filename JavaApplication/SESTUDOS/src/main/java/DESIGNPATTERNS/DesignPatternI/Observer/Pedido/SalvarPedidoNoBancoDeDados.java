package DESIGNPATTERNS.DesignPatternI.Observer.Pedido;

public class SalvarPedidoNoBancoDeDados implements Acao {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Salvando pedido no banco de dados!!");
    }
}
