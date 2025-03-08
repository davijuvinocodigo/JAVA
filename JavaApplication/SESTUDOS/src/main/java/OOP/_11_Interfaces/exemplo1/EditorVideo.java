//Gerente eh um Funcionario, Gerente herda da class Funcionario
package OOP._11_Interfaces.exemplo1;
public class EditorVideo extends Funcionario {
	
	public double getBonificacao() {
		System.out.println("Chamando o método de bonificacao do Editor de video");
		return 150;
	}	

}
