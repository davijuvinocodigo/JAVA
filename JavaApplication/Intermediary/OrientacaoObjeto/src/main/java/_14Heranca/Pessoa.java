package _14Heranca;

// Classe base Pessoa
class Pessoa {
    private String nome;
    private int idade;
    private Endereco endereco; // Composição (Pessoa TEM UM Endereco)

    public Pessoa(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    // Método comum a todas as pessoas
    public void cumprimentar() {
        System.out.println("Olá, meu nome é " + nome);
    }
}
