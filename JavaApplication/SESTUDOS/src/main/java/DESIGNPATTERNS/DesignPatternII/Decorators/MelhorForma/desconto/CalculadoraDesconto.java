package DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.desconto;

import DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.imposto.Imposto;
import DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.orcamento.Orcamento;

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
