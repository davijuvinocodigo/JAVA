package OOP._08_Polimorfismo;

public class Analista extends Funcionario {

    @Override
    public double getBonusMes() {
        System.out.println("Chamando bonus do ANALISTA...");
        return super.getBonusMes();
    }
}
