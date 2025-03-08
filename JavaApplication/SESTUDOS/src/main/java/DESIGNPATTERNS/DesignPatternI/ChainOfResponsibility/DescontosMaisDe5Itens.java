package DESIGNPATTERNS.DesignPatternI.ChainOfResponsibility;

import java.math.BigDecimal;

public class DescontosMaisDe5Itens extends Desconto{

    public DescontosMaisDe5Itens(Desconto proximo) {
        super(proximo);
    }

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        if (orcamento.getQuantidadeItens()>5){
            return orcamento.getValor().multiply(new BigDecimal("0.1"));
        }

        return proximo.calcular(orcamento);
    }
}
