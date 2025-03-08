package DESIGNPATTERNS.DesignPatternI.State.situacao;

import DESIGNPATTERNS.DesignPatternI.State.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento {
    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
