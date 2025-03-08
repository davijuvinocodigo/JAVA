package _20Polimorfismo._03ClassesFinal;

public class Galinha extends Animal {
    public Galinha(double peso, String comida) {
        super(peso,comida);
    }

    @Override
    void comportamento(){
        System.out.println("Co, Co");
    }
}
