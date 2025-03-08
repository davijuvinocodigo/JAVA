package DESIGNPATTERNS.DesignPatternI.TemplateMethod;

import java.math.BigDecimal;

public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}
