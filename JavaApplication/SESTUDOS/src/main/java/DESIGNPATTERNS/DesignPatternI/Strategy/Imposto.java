package DESIGNPATTERNS.DesignPatternI.Strategy;

import java.math.BigDecimal;

public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}
