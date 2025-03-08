package DESIGNPATTERNS.DesignPatternI.Command.Pedido;

import DESIGNPATTERNS.DesignPatternI.Command.orcamento.Orcamento;

import java.time.LocalDateTime;
import java.util.List;


public class GeraPedidoHandler {



	private List<Acao> acoes;
	public GeraPedidoHandler(List<Acao> acoes) {
		this.acoes = acoes;
	}

	public void executar(GeraPedido geraPedido) {
		Orcamento orcamento = new Orcamento(geraPedido.getValorOrcamento(), geraPedido.getQuantidadeItens());
		Pedido pedido = new Pedido(geraPedido.getCliente(), LocalDateTime.now(), orcamento);
		acoes.forEach(e -> e.executarAcao(pedido));
	}
	
}
