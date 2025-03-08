package DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.situacao;

import DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.orcamento.Orcamento;

public class Reprovado extends SituacaoDoOrcamento {
    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
