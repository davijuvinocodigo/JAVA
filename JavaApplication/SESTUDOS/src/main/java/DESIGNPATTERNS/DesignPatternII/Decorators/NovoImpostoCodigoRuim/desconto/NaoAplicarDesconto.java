package DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.desconto;

import DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.orcamento.Orcamento;

import java.math.BigDecimal;

public class NaoAplicarDesconto extends Desconto {

    public NaoAplicarDesconto() {
        super(null);
    }

    @Override
    public BigDecimal efetuarCalcular(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return true;
    }
}
