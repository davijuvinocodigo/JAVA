package OOP._10_Classes_Metodos_Abstratos.exemplo;

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
