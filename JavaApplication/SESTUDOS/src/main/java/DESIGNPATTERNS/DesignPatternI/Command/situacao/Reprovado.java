package DESIGNPATTERNS.DesignPatternI.Command.situacao;

import DESIGNPATTERNS.DesignPatternI.Command.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento {
    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
