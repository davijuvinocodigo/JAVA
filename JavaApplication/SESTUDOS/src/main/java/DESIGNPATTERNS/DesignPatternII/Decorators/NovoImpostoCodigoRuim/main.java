package DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim;

import DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.http.ApacheHttpAdapter;
import DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.orcamento.Orcamento;
import DESIGNPATTERNS.DesignPatternII.Decorators.NovoImpostoCodigoRuim.orcamento.RegistroOrcamento;

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
