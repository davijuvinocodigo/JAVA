package DESIGNPATTERNS.DesignPatternI.Observer.situacao;

import DESIGNPATTERNS.DesignPatternI.Observer.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento {
    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
