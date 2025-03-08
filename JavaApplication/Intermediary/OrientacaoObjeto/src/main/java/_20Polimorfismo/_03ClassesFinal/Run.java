package _20Polimorfismo._03ClassesFinal;

public class Run {
    public static void main(String[] args) {

        //Animal generico = new Animal(0,null);
        Animal galinha = new Galinha(1,"Milho");
        Animal cachorro = new Cachorro(2,"Racao");

        Animal.polimorfismo(galinha);
        Animal.polimorfismo(cachorro);

    }
}
