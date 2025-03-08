package DESIGNPATTERNS.DesignPatternII.Proxy;

import DESIGNPATTERNS.DesignPatternII.Proxy.orcamento.Item;
import DESIGNPATTERNS.DesignPatternII.Proxy.orcamento.Orcamento;

import java.math.BigDecimal;


public class main {

    public static void main(String[] args) {
        Orcamento antigo = new Orcamento();
        antigo.addItem(new Item(new BigDecimal("200")));
        antigo.reprovar();

        Orcamento novo = new Orcamento();
        novo.addItem(new Item(new BigDecimal("300")));
        novo.addItem(antigo);

        System.out.println(novo.getValor());
    }

}
