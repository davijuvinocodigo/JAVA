package III_LiskovSubstitutionPrinciple.exemplo02.refactored_code;

public class Avestruz extends Passaro {
	@Override
	public void voar() {
		throw new UnsupportedOperationException("Avestruz nao voar!!!!");
	}
}
