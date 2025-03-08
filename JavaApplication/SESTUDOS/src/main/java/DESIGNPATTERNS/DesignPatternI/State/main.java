package DESIGNPATTERNS.DesignPatternI.State;

import DESIGNPATTERNS.DesignPatternI.State.desconto.CalculadoraDescontos;
import DESIGNPATTERNS.DesignPatternI.State.orcamento.Orcamento;

import java.math.BigDecimal;

public class main {
    public static void main(String[] args) {
        Orcamento primeiro = new Orcamento(new BigDecimal("200"), 6);
        Orcamento segundo = new Orcamento(new BigDecimal("1000"), 1);

        CalculadoraDescontos descontos = new CalculadoraDescontos();
        System.out.println(descontos.calcular(primeiro));
        System.out.println(descontos.calcular(segundo));
    }
}
