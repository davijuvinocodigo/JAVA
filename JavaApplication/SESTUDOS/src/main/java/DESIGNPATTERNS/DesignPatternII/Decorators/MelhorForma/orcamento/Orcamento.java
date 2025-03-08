package DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.orcamento;

import DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.situacao.EmAnalise;
import DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.situacao.Finalizado;
import DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.situacao.SituacaoDoOrcamento;

import java.math.BigDecimal;

public class Orcamento {
    private BigDecimal valor;

    private int quantidadeItens;

    private SituacaoDoOrcamento situacao;

    public Orcamento(BigDecimal valor, int quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
        this.situacao = new EmAnalise();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
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
}
