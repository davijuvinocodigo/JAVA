package DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.imposto;


import DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.orcamento.Orcamento;

import java.math.BigDecimal;

public class ISS extends Imposto {

    public ISS(Imposto outro) {
        super(outro);
    }

    public BigDecimal realizarCalcular(Orcamento orcamento){
        return orcamento.getValor().multiply(new BigDecimal("0.06"));
    }
}
