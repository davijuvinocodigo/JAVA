package _20Polimorfismo._02ClassesAbstrata;

// Classe abstrata AnimalDomestico - não pode ser instanciada diretamente
public  abstract class Animal {
    private String nome;
    private int idade;

    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos abstratos que todas as subclasses devem implementar
    public abstract void emitirSom();
    public abstract void mover();

    // Método concreto que pode ser usado por todas as subclasses
    public void dormir() {
        System.out.println(nome + " está dormindo... Zzz");
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
