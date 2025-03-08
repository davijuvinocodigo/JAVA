package III_LiskovSubstitutionPrinciple.exemplo01.old;

import java.util.ArrayList;
import java.util.List;

public class Programa {
	public static void main(String[] args) {
		List<Funcionario> funcionario = new ArrayList<>();
		funcionario.add(new FuncionarioDeFerias());
		funcionario.add(new Funcionario());
		 
		Projeto projeto = new Projeto();
		projeto.iniciar(funcionario);

	}

}
