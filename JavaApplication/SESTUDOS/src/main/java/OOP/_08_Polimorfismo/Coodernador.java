package OOP._08_Polimorfismo;

public class Coodernador extends Funcionario {

    @Override
    public double getBonusMes() {
        System.out.println("Chamando bonus do COODERNADOR...");
        return super.getBonusMes() + 200;
    }
}
