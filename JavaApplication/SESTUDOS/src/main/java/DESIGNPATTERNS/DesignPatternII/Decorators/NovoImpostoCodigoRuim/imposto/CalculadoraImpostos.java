package DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.imposto;

import DESIGNPATTERNS.DesignPatternI.Strategy.Imposto;
import DESIGNPATTERNS.DesignPatternI.Strategy.Orcamento;

import java.math.BigDecimal;

public class CalculadoraImpostos {
    public BigDecimal calcular(Orcamento orcamento, Imposto imposto){
        return imposto.calcular(orcamento);
    }
}
