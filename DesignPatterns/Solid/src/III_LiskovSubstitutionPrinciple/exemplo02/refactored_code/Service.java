package III_LiskovSubstitutionPrinciple.exemplo02.refactored_code;

import java.util.List;

public class Service {
	
	public void deixaOsPassarosVoarem (List<Passaro> passaros){
        for ( Passaro passaro:passaros) {
            passaro.voar();
        }
    }
}
