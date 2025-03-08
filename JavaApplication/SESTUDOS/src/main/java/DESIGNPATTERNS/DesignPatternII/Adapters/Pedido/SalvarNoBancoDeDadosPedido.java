package DESIGNPATTERNS.DesignPatternII.Adapters.Pedido;

public class SalvarNoBancoDeDadosPedido implements AcaoPedido {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Salvando pedido no banco de dados!!");
    }
}
