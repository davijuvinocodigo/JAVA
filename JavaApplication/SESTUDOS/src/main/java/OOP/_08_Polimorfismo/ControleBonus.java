package OOP._08_Polimorfismo;

public class ControleBonus {

    private double soma;

    public void registrar(Funcionario f){

        double bonus = f.getBonusMes();
        this.soma = this.soma + bonus;
    }

    public double getSoma() {
        return soma;
    }
}
