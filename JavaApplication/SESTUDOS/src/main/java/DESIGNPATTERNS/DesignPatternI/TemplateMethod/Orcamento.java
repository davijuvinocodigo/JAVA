package DESIGNPATTERNS.DesignPatternI.TemplateMethod;

import java.math.BigDecimal;

public class Orcamento {
    private BigDecimal valor;

    private int quantidadeItens;

    public Orcamento(BigDecimal valor, int quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void aplicarDescontoExtra(){
        BigDecimal valorDoDescontoExtra = BigDecimal.ZERO;
    }
    public int getQuantidadeItens() {
        return quantidadeItens;
    }
}
