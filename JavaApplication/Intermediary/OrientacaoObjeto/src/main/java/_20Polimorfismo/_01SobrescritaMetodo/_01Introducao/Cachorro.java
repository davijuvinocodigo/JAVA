package _20Polimorfismo._01SobrescritaMetodo._01Introducao;

public class Cachorro extends Animal{
    public Cachorro(double peso, String comida) {
        super(peso, comida);
    }


    @Override
    void comportamento() {
        System.out.println("Au, Au");
    }
}
