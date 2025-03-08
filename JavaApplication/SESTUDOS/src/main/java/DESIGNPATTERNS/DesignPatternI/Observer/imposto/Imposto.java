package DESIGNPATTERNS.DesignPatternI.Observer.imposto;

import DESIGNPATTERNS.DesignPatternI.Observer.orcamento.Orcamento;

import java.math.BigDecimal;

public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}
