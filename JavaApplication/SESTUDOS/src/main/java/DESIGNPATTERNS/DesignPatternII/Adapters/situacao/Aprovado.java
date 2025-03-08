package DESIGNPATTERNS.DesignPatternII.Adapters.situacao;

import DESIGNPATTERNS.DesignPatternII.Adapters.orcamento.Orcamento;

import java.math.BigDecimal;

public class Aprovado extends SituacaoDoOrcamento {
    @Override
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento){
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
