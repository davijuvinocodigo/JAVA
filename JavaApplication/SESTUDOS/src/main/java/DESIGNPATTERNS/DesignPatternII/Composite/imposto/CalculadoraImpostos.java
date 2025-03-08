package DESIGNPATTERNS.DesignPatternII.Composite.imposto;



import DESIGNPATTERNS.DesignPatternII.Composite.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraImpostos {
    public BigDecimal calcular(Orcamento orcamento, Imposto imposto){
        return imposto.calcular(orcamento);
    }
}
