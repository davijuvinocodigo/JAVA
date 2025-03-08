package _20Polimorfismo._01SobrescritaMetodo._01Introducao;

public class Animal {
    double peso;
    String comida;

    public Animal(double peso, String comida) {
        this.peso = peso;
        this.comida = comida;
    }

    void domir(){
        System.out.println("Dormiu");
    }

    void comportamento(){
        System.out.println("comportamento");
    }

    static void polimorfismo(Animal animal){
        animal.comportamento();
    }
}
