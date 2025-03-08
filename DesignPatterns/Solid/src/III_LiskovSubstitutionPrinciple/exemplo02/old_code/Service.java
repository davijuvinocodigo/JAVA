package III_LiskovSubstitutionPrinciple.exemplo02.old_code;

import java.util.List;

public class Service {
	
	public void deixaOsPassarosVoarem (List<Passaro> passaros){
        for ( Passaro passaro:passaros) {
            passaro.voar();
        }
    }
}
