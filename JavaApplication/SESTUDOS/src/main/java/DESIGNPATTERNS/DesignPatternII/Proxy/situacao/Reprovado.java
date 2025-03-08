package DESIGNPATTERNS.DesignPatternII.Proxy.situacao;

import DESIGNPATTERNS.DesignPatternII.Proxy.orcamento.Orcamento;

public class Reprovado extends SituacaoDoOrcamento {
    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
