package DESIGNPATTERNS.DesignPatternII.Proxy.imposto;

import DESIGNPATTERNS.DesignPatternII.Proxy.orcamento.Orcamento;

import java.math.BigDecimal;

public class ICMS extends Imposto {

    public ICMS(Imposto outro) {
        super(outro);
    }

    public BigDecimal realizarCalcular(Orcamento orcamento){
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }
}
