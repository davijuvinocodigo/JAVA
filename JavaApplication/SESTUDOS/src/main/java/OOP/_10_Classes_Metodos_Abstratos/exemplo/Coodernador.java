package OOP._10_Classes_Metodos_Abstratos.exemplo;

public class Coodernador extends Funcionario {

    @Override
    public double getBonusMes() {
        System.out.println("Chamando bonus do COODERNADOR...");
        return 200;
    }
}
