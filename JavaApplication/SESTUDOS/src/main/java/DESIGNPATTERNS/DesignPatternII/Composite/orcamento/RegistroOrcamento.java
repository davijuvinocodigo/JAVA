package DESIGNPATTERNS.DesignPatternII.Composite.orcamento;

import DESIGNPATTERNS.DesignPatternII.Composite.MyException;
import DESIGNPATTERNS.DesignPatternII.Composite.http.HttpAdapter;

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
