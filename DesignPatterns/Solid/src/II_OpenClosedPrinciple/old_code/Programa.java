package II_OpenClosedPrinciple.old_code;

import java.math.BigDecimal;

public class Programa {
	public static void main(String[] args) {
		DescontoService descontoService = new DescontoService();
		
		BigDecimal vlrDesconto = new BigDecimal("14.00");
		BigDecimal vlrDescontoSenior = new BigDecimal("14.00");
		
		
		System.out.println("Valor : " + "R$ " + vlrDesconto);
		System.out.println("Aplicar Desconto: " + "R$ "
									+ descontoService.descontoAplicarService(
											vlrDesconto, new Desconto()));
		System.out.println("Valor para Senior: " + "R$ " + vlrDescontoSenior);
		System.out.println("Aplicar Desconto Senior: " +"R$ " 
									+ descontoService.seniorDescontoAplicarService(
											vlrDescontoSenior, new DescontoSenior()));

	}

}
