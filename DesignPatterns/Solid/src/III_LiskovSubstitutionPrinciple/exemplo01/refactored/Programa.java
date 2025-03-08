package III_LiskovSubstitutionPrinciple.exemplo01.refactored;

import java.util.ArrayList;
import java.util.List;

public class Programa {
	public static void main(String[] args) {
		List<FuncionarioTrabalhando> funcionarios = new ArrayList<>();
		funcionarios.add(new FuncionarioTrabalhandoImpl());
		Projeto projeto = new Projeto();
		projeto.iniciar(funcionarios);

	}

}
