package DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.imposto;

import DESIGNPATTERNS.DesignPatternI.Strategy.ISS;
import DESIGNPATTERNS.DesignPatternI.Strategy.Imposto;
import DESIGNPATTERNS.DesignPatternI.Strategy.Orcamento;

import java.math.BigDecimal;

public class ICMSComISS implements Imposto {
    public BigDecimal calcular(Orcamento orcamento){
        BigDecimal icms = new ICMS().calcular(orcamento);
        BigDecimal iss = new ISS().calcular(orcamento);
        return icms.add(iss);
    }
}
