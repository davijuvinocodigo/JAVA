package II_OpenClosedPrinciple.old_code;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DescontoSenior {

	public BigDecimal seniorDescontoAplicar(BigDecimal preco) {
		 
        BigDecimal porcentage = new BigDecimal("0.20");
        BigDecimal desconto = preco.multiply(porcentage);
        return preco.subtract(desconto.setScale(2, RoundingMode.HALF_UP));
    }
}
