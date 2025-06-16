package _20Polimorfismo._02ClassesAbstrata;

// Subclasse Gato
public class Gato extends Animal {
    private boolean temPelagemLonga;

    public Gato(String nome, int idade, boolean temPelagemLonga) {
        super(nome, idade);
        this.temPelagemLonga = temPelagemLonga;
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " diz: Miau!");
    }

    @Override
    public void mover() {
        System.out.println(getNome() + " está andando silenciosamente");
    }

    // Método específico de Gato
    public void arranhar() {
        System.out.println(getNome() + " está afiando as unhas");
    }
}
