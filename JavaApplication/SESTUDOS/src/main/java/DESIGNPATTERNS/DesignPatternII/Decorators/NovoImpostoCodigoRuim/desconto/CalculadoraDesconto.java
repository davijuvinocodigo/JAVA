package DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.desconto;

import DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.imposto.Imposto;
import DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.orcamento.Orcamento;

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
