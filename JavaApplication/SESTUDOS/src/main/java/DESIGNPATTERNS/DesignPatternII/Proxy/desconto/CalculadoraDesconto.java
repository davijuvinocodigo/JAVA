package DESIGNPATTERNS.DesignPatternII.Proxy.desconto;

import DESIGNPATTERNS.DesignPatternII.Proxy.imposto.Imposto;
import DESIGNPATTERNS.DesignPatternII.Proxy.orcamento.Orcamento;

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
