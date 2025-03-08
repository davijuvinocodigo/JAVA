package DESIGNPATTERNS.DesignPatternII.Proxy.orcamento;

import DESIGNPATTERNS.DesignPatternII.Proxy.MyException;
import DESIGNPATTERNS.DesignPatternII.Proxy.http.HttpAdapter;

import java.util.Map;

public class RegistroOrcamento {

	private HttpAdapter httpAdapter;

	public RegistroOrcamento(HttpAdapter httpAdapter) {
		this.httpAdapter = httpAdapter;
	}

	public void registrar(Orcamento orcamento) {
		if (!orcamento.isFinalizado()) {
			throw new MyException("Orcamento nao finalizado nao pode ser registrado!");
		}

		String urlApi = "http://api.xyz/orcamento";
		Map<String, Object> dadosApi = Map.of(
			"valor", orcamento.getValor(),
			"quantidadeItens", orcamento.getQuantidadeItens()
		);

		httpAdapter.post(urlApi, dadosApi);
	}

}
