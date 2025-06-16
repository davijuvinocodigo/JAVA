package _20Polimorfismo._02ClassesAbstrata;

// Subclasse Pássaro
public class Passaro extends Animal {
    private String corPenas;

    public Passaro(String nome, int idade, String corPenas) {
        super(nome, idade);
        this.corPenas = corPenas;
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " diz: Piu piu!");
    }

    @Override
    public void mover() {
        System.out.println(getNome() + " está voando pelos ares");
    }

    // Método específico de Pássaro
    public void construirNinho() {
        System.out.println(getNome() + " está construindo um ninho com galhos");
    }
}
