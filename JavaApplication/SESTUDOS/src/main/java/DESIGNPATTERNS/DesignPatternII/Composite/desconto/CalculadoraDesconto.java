package DESIGNPATTERNS.DesignPatternII.Composite.desconto;

import DESIGNPATTERNS.DesignPatternII.Composite.imposto.Imposto;
import DESIGNPATTERNS.DesignPatternII.Composite.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDesconto extends Imposto {

    public CalculadoraDesconto(Imposto outro) {
        super(outro);
    }

    @Override
    public BigDecimal realizarCalcular(Orcamento orcamento) {
        Desconto desconto = new MaiorDe500Desconto(
                new MaisDe5ItensDesconto(
                        new NaoAplicarDesconto()));
        return desconto.calcular(orcamento);
    }
}
