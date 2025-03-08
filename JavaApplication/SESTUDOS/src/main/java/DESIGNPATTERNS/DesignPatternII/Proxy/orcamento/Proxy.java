package DESIGNPATTERNS.DesignPatternII.Proxy.orcamento;

import java.math.BigDecimal;

public class Proxy extends Orcamento{
    private BigDecimal valor;
    private Orcamento orcamento;

    public Proxy(BigDecimal valor, Orcamento orcamento) {
        this.valor = valor;
        this.orcamento = orcamento;
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }
}
