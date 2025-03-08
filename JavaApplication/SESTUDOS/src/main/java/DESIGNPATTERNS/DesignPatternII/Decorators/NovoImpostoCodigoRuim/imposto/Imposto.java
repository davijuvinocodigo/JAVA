package DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.imposto;

import DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.orcamento.Orcamento;

import java.math.BigDecimal;

public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}
