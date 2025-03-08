package DESIGNPATTERNS.DesignPatternI.Command.desconto;

import DESIGNPATTERNS.DesignPatternI.Command.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontosMaisDe5Itens extends Desconto {

    public DescontosMaisDe5Itens(Desconto proximo) {
        super(proximo);
    }

    @Override
    public BigDecimal efetuarCalcular(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getQuantidadeItens()>5;
    }
}
