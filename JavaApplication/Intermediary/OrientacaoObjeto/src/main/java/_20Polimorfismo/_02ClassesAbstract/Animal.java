package _20Polimorfismo._02ClassesAbstract;

public abstract class Animal {
    double peso;
    String comida;

    public Animal(double peso, String comida) {
        this.peso = peso;
        this.comida = comida;
    }

    void domir(){
        System.out.println("Dormiu");
    }

    abstract void comportamento();

    static void polimorfismo(Animal animal){
        animal.comportamento();
    }
}
