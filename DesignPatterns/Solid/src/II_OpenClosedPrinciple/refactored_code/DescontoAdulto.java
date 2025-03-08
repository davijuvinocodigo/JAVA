package II_OpenClosedPrinciple.refactored_code;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DescontoAdulto implements Desconto {

    @Override
    public BigDecimal aplicar(BigDecimal preco) {

        BigDecimal porcentage = new BigDecimal("0.10");
        BigDecimal desconto = preco.multiply(porcentage);
        return preco.subtract(desconto.setScale(2, RoundingMode.HALF_UP));
    }
}
