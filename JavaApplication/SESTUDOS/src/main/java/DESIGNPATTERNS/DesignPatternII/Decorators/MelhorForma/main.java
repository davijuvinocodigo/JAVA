package DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma;

import DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.imposto.ICMS;
import DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.imposto.ISS;
import DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.orcamento.Orcamento;
import DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.imposto.CalculadoraImpostos;


import java.math.BigDecimal;


public class main {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
        CalculadoraImpostos calculadora = new CalculadoraImpostos();
        System.out.println(calculadora.calcular(orcamento, new ISS(new ICMS(null))));
    }

}
