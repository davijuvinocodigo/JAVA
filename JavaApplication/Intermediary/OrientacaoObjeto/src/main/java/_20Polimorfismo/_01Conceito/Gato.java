package _20Polimorfismo._01Conceito;

// Subclasse Gato
class Gato extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }

    // Não sobrescreve mover(), usa a implementação da superclasse
}
