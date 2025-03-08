package DESIGNPATTERNS.DesignPatternII.Composite.situacao;

import DESIGNPATTERNS.DesignPatternII.Composite.orcamento.Orcamento;

import java.math.BigDecimal;

public class EmAnalise extends SituacaoDoOrcamento {

    @Override
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    @Override
    public void aprovar(Orcamento orcamento) {
        orcamento.setSituacao(new Aprovado());
    }

    @Override
    public void reprovar(Orcamento orcamento) {
        orcamento.setSituacao(new Reprovado());
    }


}
