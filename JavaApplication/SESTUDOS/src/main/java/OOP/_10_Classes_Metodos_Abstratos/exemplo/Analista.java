package OOP._10_Classes_Metodos_Abstratos.exemplo;

public class Analista extends Funcionario {

    @Override
    public double getBonusMes() {
        System.out.println("Chamando bonus do ANALISTA...");
        return 0.6;
    }
}
