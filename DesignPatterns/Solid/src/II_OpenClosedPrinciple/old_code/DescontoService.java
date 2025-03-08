package II_OpenClosedPrinciple.old_code;

import java.math.BigDecimal;

public class DescontoService {

	public BigDecimal descontoAplicarService(BigDecimal preco, Desconto desconto) {
		
		 BigDecimal descontoPreco = preco.add(BigDecimal.ZERO);
		 descontoPreco = desconto.descontoAplicar(descontoPreco);
	     return descontoPreco;
    }
	
	public BigDecimal seniorDescontoAplicarService(BigDecimal preco, DescontoSenior desconto) {
        return desconto.seniorDescontoAplicar(preco);
    }
}
