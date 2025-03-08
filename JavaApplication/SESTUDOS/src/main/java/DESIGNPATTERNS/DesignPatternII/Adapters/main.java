package DESIGNPATTERNS.DesignPatternII.Adapters;

import DESIGNPATTERNS.DesignPatternII.Adapters.http.ApacheHttpAdapter;
import DESIGNPATTERNS.DesignPatternII.Adapters.orcamento.Orcamento;
import DESIGNPATTERNS.DesignPatternII.Adapters.orcamento.RegistroOrcamento;

import java.math.BigDecimal;


public class main {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(BigDecimal.TEN, 1);
        orcamento.aprovar();
        orcamento.finalizar();

        RegistroOrcamento registro = new RegistroOrcamento(new ApacheHttpAdapter());
        registro.registrar(orcamento);
    }


}
