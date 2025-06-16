package _20Polimorfismo._01Conceito;

// Subclasse Cachorro
class Cachorro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Au au!");
    }

    @Override
    public void mover() {
        System.out.println("Cachorro correndo");
    }

    // Novo método específico de Cachorro
    public void abanarRabo() {
        System.out.println("Cachorro abanando o rabo");
    }
}
