package DESIGNPATTERNS.DesignPatternI.Observer.desconto;

import DESIGNPATTERNS.DesignPatternI.Observer.imposto.Imposto;
import DESIGNPATTERNS.DesignPatternI.Observer.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDescontos implements Imposto {

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        Desconto desconto = new DescontoMaior500(
                new DescontosMaisDe5Itens(
                        new NaoAplicarDesconto()));
        return desconto.calcular(orcamento);
    }
}
