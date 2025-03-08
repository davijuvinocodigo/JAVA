package DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.Pedido;

import DESIGNPATTERNS.DesignPatternII.Decorators.MelhorForma.orcamento.Orcamento;

import java.time.LocalDateTime;

public class Pedido {
    private String cliente;
    private LocalDateTime date;
    private Orcamento orcamento;

    public Pedido(String cliente, LocalDateTime now, Orcamento orcamento) {
        this.cliente = cliente;
        this.date = now;
        this.orcamento = orcamento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }
}
