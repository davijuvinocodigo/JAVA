package DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.imposto;

import DESIGNPATTERNS.DesignPatternI.Strategy.Imposto;
import DESIGNPATTERNS.DesignPatternI.Strategy.Orcamento;

import java.math.BigDecimal;

public class ICMS implements Imposto {
    public BigDecimal calcular(Orcamento orcamento){
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }
}
