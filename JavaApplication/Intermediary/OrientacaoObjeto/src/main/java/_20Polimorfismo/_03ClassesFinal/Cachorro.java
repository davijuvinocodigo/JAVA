package _20Polimorfismo._03ClassesFinal;

public class Cachorro extends Animal {
    public Cachorro(double peso, String comida) {
        super(peso, comida);
    }

   /*void domir(){

   }*/ //não podemos instaciar


    @Override
    void comportamento() {
        System.out.println("Au, Au");
    }
}
