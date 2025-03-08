package DESIGNPATTERNS.DesignPatternII.Adapters.desconto;

import DESIGNPATTERNS.DesignPatternII.Adapters.imposto.Imposto;
import DESIGNPATTERNS.DesignPatternII.Adapters.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDesconto implements Imposto {

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        Desconto desconto = new MaiorDe500Desconto(
                new MaisDe5ItensDesconto(
                        new NaoAplicarDesconto()));
        return desconto.calcular(orcamento);
    }
}
