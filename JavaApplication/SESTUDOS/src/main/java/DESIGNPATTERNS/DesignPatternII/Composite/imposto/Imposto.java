package DESIGNPATTERNS.DesignPatternII.Composite.imposto;

import DESIGNPATTERNS.DesignPatternII.Composite.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class Imposto {

    private Imposto outro;

    public Imposto(Imposto outro) {
        this.outro = outro;
    }

    protected abstract BigDecimal realizarCalcular(Orcamento orcamento);

    public BigDecimal calcular(Orcamento orcamento){
        BigDecimal valorImposto = realizarCalcular(orcamento);
        BigDecimal valorDoOutroImposto = BigDecimal.ZERO;
        if(outro != null){
            valorDoOutroImposto = outro.realizarCalcular(orcamento);
        }
        return valorImposto.add(valorDoOutroImposto);
    }
}
