package DESIGNPATTERNS.DesignPatternI.Observer.situacao;

import DESIGNPATTERNS.DesignPatternI.Observer.DomainException;
import DESIGNPATTERNS.DesignPatternI.Observer.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class SituacaoOrcamento {

    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento){
        return BigDecimal.ZERO;
    }
    public void aprovar(Orcamento orcamento){
        throw new DomainException("Orcamento nao pode ser aprovado!");
    }

    public void reprovar(Orcamento orcamento){
        throw new DomainException("Orcamento nao pode ser aprovado!");
    }

    public void finalizar(Orcamento orcamento){
        throw new DomainException("Orcamento nao pode ser finalizado!");
    }
}
