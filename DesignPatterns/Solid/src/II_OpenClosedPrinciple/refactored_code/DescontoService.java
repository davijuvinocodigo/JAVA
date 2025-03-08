package II_OpenClosedPrinciple.refactored_code;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DescontoService {
	
    public Map<BigDecimal, Object> aplicarDescontos(BigDecimal preco, Desconto[] descontos) {
    	
        BigDecimal descontoPreco = preco.add(BigDecimal.ZERO);
        Map<BigDecimal, Object> mapObjects = new HashMap<BigDecimal, Object>();
        
        for(Desconto desconto:descontos) {
        	descontoPreco = desconto.aplicar(descontoPreco);
        	mapObjects.put(descontoPreco, desconto.getClass().getSimpleName());
        	
        }

        return mapObjects;
    }
}
