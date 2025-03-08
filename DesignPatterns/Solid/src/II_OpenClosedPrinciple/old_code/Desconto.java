package II_OpenClosedPrinciple.old_code;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Desconto {
	
	public BigDecimal descontoAplicar(BigDecimal preco) {
		 
        BigDecimal porcentage = new BigDecimal("0.10");
        BigDecimal desconto = preco.multiply(porcentage);
        return preco.subtract(desconto.setScale(2, RoundingMode.HALF_UP));
    }

}
