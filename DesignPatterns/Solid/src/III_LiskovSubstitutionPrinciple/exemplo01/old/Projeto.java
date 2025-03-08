package III_LiskovSubstitutionPrinciple.exemplo01.old;

import java.util.List;

public class Projeto {
	public void iniciar(List<Funcionario> funcionarios) { 
        for(Funcionario funcionario:funcionarios) {
            funcionario.trabalhar();
        }
    }
}
