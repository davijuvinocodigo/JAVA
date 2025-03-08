package II_OpenClosedPrinciple.refactored_code;

import java.math.BigDecimal;

public class Programa {
	public static void main(String[] args) {
		
		BigDecimal valor = new BigDecimal("14.00");
		DescontoService descontoService = new DescontoService();
		
		Desconto[] descontos = { 
						new DescontoAdulto(),
						new DescontoSenior(),
						new DescontoBasico()
					};
		
		System.out.println("Aplicar Descontos: "
				+ "R$ " + descontoService.aplicarDescontos(valor, descontos));


	}

}
