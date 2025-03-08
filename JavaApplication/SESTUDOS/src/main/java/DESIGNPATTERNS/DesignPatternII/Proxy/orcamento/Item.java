package DESIGNPATTERNS.DesignPatternII.Proxy.orcamento;

import java.math.BigDecimal;

public class Item implements Orcavel {
    private BigDecimal valor;

    public Item(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
