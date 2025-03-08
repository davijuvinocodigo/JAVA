package DESIGNPATTERNS.DesignPatternII.Composite;

import DESIGNPATTERNS.DesignPatternII.Composite.orcamento.Item;
import DESIGNPATTERNS.DesignPatternII.Composite.orcamento.Orcamento;

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
