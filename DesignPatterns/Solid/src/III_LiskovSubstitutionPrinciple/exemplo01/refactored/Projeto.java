package III_LiskovSubstitutionPrinciple.exemplo01.refactored;

import java.util.List;

public class Projeto {
	public void iniciar(List<FuncionarioTrabalhando> funcionariosTrabalhando) {	 
        for(FuncionarioTrabalhando funcionarioTrabalhando:funcionariosTrabalhando) {
            	funcionarioTrabalhando.trabalhar();
        }
    }
}
