package DESIGNPATTERNS.DesignPatternI.Observer.Pedido;

import DESIGNPATTERNS.DesignPatternI.Observer.orcamento.Orcamento;

import java.time.LocalDateTime;
import java.util.List;


public class GeraPedidoHandler {



	private List<Acao> acoes;
	public GeraPedidoHandler(List<Acao> acoes) {
		this.acoes = acoes;
	}

	public void executar(GeraPedido dados) {
		Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
		acoes.forEach(e -> e.executarAcao(pedido));
	}
	
}
