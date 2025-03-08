package III_LiskovSubstitutionPrinciple.exemplo02.refactored_code;

import java.util.ArrayList;
import java.util.List;

public class programa {
	Service service;
	public static void main(String[] args){
        
		List<Passaro> passaros = new ArrayList<Passaro>();
		Service s = new Service();
		
        passaros.add(new Passaro());
        passaros.add(new Corvo());
        passaros.add(new Avestruz());
       
        s.deixaOsPassarosVoarem(passaros);
        
    } 
}
