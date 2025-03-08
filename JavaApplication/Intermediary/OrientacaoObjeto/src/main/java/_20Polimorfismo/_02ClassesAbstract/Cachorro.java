package _20Polimorfismo._02ClassesAbstract;

public class Cachorro extends Animal {
    public Cachorro(double peso, String comida) {
        super(peso, comida);
    }


    @Override
    void comportamento() {
        System.out.println("Au, Au");
    }
}
