package DESIGNPATTERNS.DesignPatternI.Strategy;

import java.math.BigDecimal;

public class main {
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"));
        CalculadoraImpostos calculadora = new CalculadoraImpostos();
        System.out.println(calculadora.calcular(orcamento, new ISS()));
    }
}
