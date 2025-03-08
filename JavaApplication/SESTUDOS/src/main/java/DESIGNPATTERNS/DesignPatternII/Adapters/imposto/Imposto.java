package DESIGNPATTERNS.DesignPatternII.Adapters.imposto;

import DESIGNPATTERNS.DesignPatternII.Adapters.orcamento.Orcamento;

import java.math.BigDecimal;

public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}
