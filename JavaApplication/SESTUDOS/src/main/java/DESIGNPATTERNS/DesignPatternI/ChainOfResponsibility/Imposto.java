package DESIGNPATTERNS.DesignPatternI.ChainOfResponsibility;

import java.math.BigDecimal;

public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}
