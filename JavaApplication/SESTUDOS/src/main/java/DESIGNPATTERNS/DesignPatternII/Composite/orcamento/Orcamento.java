package DESIGNPATTERNS.DesignPatternII.Composite.orcamento;

import DESIGNPATTERNS.DesignPatternII.Composite.situacao.EmAnalise;
import DESIGNPATTERNS.DesignPatternII.Composite.situacao.Finalizado;
import DESIGNPATTERNS.DesignPatternII.Composite.situacao.SituacaoDoOrcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Orcamento implements Orcavel {
    private BigDecimal valor;

    private List<Orcavel> itens;

    private SituacaoDoOrcamento situacao;

    public Orcamento() {
        this.valor = BigDecimal.ZERO;
        this. itens = new ArrayList<>();
        this.situacao = new EmAnalise();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    public SituacaoDoOrcamento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoDoOrcamento situacaoDoOrcamento) {
        this.situacao = situacaoDoOrcamento;
    }

    public void aplicarDescontoExtra(){
        BigDecimal valorDoDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
        this.valor = this.valor.subtract(valorDoDescontoExtra);
    }

    public void aprovar(){
        this.situacao.aprovar(this);
    }

    public void reprovar(){
        this.situacao.reprovar(this);
    }

    public void finalizar(){
        this.situacao.finalizar(this);
    }

    public boolean isFinalizado() {
        return this.situacao instanceof Finalizado;
    }

    public void addItem(Orcavel item){
        this.valor = valor.add(item.getValor());
        this.itens.add(item);
    }
}
