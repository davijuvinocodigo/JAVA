package DESIGNPATTERNS.DesignPatternI.Observer;


import DESIGNPATTERNS.DesignPatternI.Observer.Pedido.EnviarEmailPedido;
import DESIGNPATTERNS.DesignPatternI.Observer.Pedido.GeraPedido;
import DESIGNPATTERNS.DesignPatternI.Observer.Pedido.GeraPedidoHandler;
import DESIGNPATTERNS.DesignPatternI.Observer.Pedido.SalvarPedidoNoBancoDeDados;

import java.math.BigDecimal;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        String cliente = "Ana da Silva";
        BigDecimal valorOrcamento = new BigDecimal("745.99");
        int quantidadeItens = 3;

        GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
        GeraPedidoHandler handler = new GeraPedidoHandler(
                Arrays.asList(new SalvarPedidoNoBancoDeDados(),
                        new EnviarEmailPedido())
        );
        handler.executar(gerador);

    }
}
