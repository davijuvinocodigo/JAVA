package DESIGNPATTERNS.DesignPatternII.Adapters.situacao;

import DESIGNPATTERNS.DesignPatternII.Adapters.MyException;
import DESIGNPATTERNS.DesignPatternII.Adapters.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class SituacaoDoOrcamento {

    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento){
        return BigDecimal.ZERO;
    }
    public void aprovar(Orcamento orcamento){
        throw new MyException("Orcamento nao pode ser aprovado!");
    }

    public void reprovar(Orcamento orcamento){
        throw new MyException("Orcamento nao pode ser aprovado!");
    }

    public void finalizar(Orcamento orcamento){
        throw new MyException("Orcamento nao pode ser finalizado!");
    }
}
