package DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.desconto;

import DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.orcamento.Orcamento;

import java.math.BigDecimal;

public class MaiorDe500Desconto extends Desconto {

    public MaiorDe500Desconto(Desconto proximo) {
        super(proximo);
    }

    @Override
    public BigDecimal efetuarCalcular(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getValor().compareTo(new BigDecimal("500"))>0;
    }
}
