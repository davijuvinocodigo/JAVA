package _20Polimorfismo._03ClassesFinal;

class Animal {
    private String nome;

    public String getNome() {
        return nome;
    }

    public Animal(String nome) {
        this.nome = nome;
    }

    // Método final - não pode ser sobrescrito
    public final void respirar() {
        System.out.println(nome + " está respirando");
    }

    public void emitirSom() {
        System.out.println(nome + " está emitindo um som genérico");
    }
}

class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " diz: Au au!");
    }

    // Tentativa de sobrescrever método final (geraria erro)
    /*
    @Override
    public void respirar() {  // Erro: Cannot override the final method from Animal
        System.out.println("Respiração especial de cachorro");
    }
    */
}

public class ExemploMetodoFinal {
    public static void main(String[] args) {
        Cachorro rex = new Cachorro("Rex");
        rex.respirar();   // Rex está respirando (método final)
        rex.emitirSom();   // Rex diz: Au au!
    }
}