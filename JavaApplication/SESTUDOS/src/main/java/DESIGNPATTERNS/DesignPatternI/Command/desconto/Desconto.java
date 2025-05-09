package DESIGNPATTERNS.DesignPatternI.Command.desconto;

import DESIGNPATTERNS.DesignPatternI.Command.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class Desconto {

    protected Desconto proximo;

    public Desconto(Desconto proximo){
        this.proximo = proximo;
    }

    public BigDecimal calcular(Orcamento orcamento){
        if (deveAplicar(orcamento)){
            return efetuarCalcular(orcamento);
        }
        return proximo.calcular(orcamento);
    }
    protected abstract BigDecimal efetuarCalcular(Orcamento orcamento);
    public abstract boolean deveAplicar(Orcamento orcamento);

}
