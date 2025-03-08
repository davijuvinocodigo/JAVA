package DESIGNPATTERNS.DesignPatternI.ChainOfResponsibility;

import java.math.BigDecimal;

public class NaoAplicarDesconto extends Desconto{

    public NaoAplicarDesconto() {
        super(null);
    }

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }
}
