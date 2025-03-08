package DESIGNPATTERNS.DesignPatternII.Composite.situacao;

import DESIGNPATTERNS.DesignPatternII.Composite.orcamento.Orcamento;

public class Reprovado extends SituacaoDoOrcamento {
    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
