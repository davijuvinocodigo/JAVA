package DESIGNPATTERNS.DesignPatternI.Command.desconto;

import DESIGNPATTERNS.DesignPatternI.Command.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoMaior500 extends Desconto {

    public DescontoMaior500(Desconto proximo) {
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
