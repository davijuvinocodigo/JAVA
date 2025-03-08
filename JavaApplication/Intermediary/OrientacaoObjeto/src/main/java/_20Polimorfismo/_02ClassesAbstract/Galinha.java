package _20Polimorfismo._02ClassesAbstract;

public class Galinha extends Animal {
    public Galinha(double peso, String comida) {
        super(peso,comida);
    }

    @Override
    void comportamento(){
        System.out.println("Co, Co");
    }
}
