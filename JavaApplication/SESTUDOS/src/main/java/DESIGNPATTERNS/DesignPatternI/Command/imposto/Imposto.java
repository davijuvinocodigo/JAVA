package DESIGNPATTERNS.DesignPatternI.Command.imposto;

import DESIGNPATTERNS.DesignPatternI.Command.orcamento.Orcamento;

import java.math.BigDecimal;

public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}
