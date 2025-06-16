package _20Polimorfismo._02ClassesAbstrata;

// Subclasse Cachorro
public class Cachorro extends Animal {
    private String raca;

    public Cachorro(String nome, int idade, String raca) {
        super(nome, idade);
        this.raca = raca;
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " diz: Au au!");
    }

    @Override
    public void mover() {
        System.out.println(getNome() + " está correndo com suas 4 patas");
    }

    // Método específico de Cachorro
    public void abanarRabo() {
        System.out.println(getNome() + " está abanando o rabo feliz!");
    }
}
