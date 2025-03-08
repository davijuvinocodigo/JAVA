package DESIGNPATTERNS.DesignPatternII.Proxy.Pedido;

import DESIGNPATTERNS.DesignPatternII.Proxy.orcamento.Orcamento;

import java.time.LocalDateTime;
import java.util.List;


public class HandlerGerarPedido {



	private List<AcaoPedido> acoes;
	public HandlerGerarPedido(List<AcaoPedido> acoes) {
		this.acoes = acoes;
	}

	public void executar(GeraPedido dados) {
		Orcamento orcamento = new Orcamento();
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
		acoes.forEach(e -> e.executarAcao(pedido));
	}
	
}
