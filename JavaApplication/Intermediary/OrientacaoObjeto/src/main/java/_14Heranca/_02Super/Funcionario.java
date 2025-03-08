package _14Heranca._02Super;

public class Funcionario extends Pessoa {
    private double salario;

    //Sobrescrever o metodo imprime Pessoa
    public void imprime(){
        super.imprime();
        System.out.println(this.salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
