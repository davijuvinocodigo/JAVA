package DESIGNPATTERNS.DesignPatternII.Proxy.desconto;

import DESIGNPATTERNS.DesignPatternII.Proxy.orcamento.Orcamento;

import java.math.BigDecimal;

public class MaisDe5ItensDesconto extends Desconto {

    public MaisDe5ItensDesconto(Desconto proximo) {
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
