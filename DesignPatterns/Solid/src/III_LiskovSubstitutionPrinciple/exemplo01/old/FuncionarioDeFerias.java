package III_LiskovSubstitutionPrinciple.exemplo01.old;

public class FuncionarioDeFerias extends Funcionario {
	@Override
	public void trabalhar() {
		throw new IllegalArgumentException("Funcionario de ferias nao deve esta trabalhando.");
	}
}
