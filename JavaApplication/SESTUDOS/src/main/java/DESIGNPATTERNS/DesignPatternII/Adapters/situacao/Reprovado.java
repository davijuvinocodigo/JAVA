package DESIGNPATTERNS.DesignPatternII.Adapters.situacao;

import DESIGNPATTERNS.DesignPatternII.Adapters.orcamento.Orcamento;

public class Reprovado extends SituacaoDoOrcamento {
    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
