package _14Heranca.conceito;

// 1. Classe Base (Superclasse)
class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void cumprimentar() {
        System.out.println("Olá, eu sou " + nome);
    }

    // Getter (para a classe filha acessar 'nome')
    public String getNome() {
        return nome;
    }
}

// 2. Classe Derivada (Subclasse) - HERDA de Pessoa
class Funcionario extends Pessoa {
    private String matricula;

    public Funcionario(String nome, int idade, String matricula) {
        super(nome, idade); // Chama o construtor da Pessoa
        this.matricula = matricula;
    }

    // Método ESPECÍFICO do Funcionario
    public void baterPonto() {
        System.out.println(getNome() + " bateu o ponto (Matrícula: " + matricula + ")");
    }

    // SOBRESCRITA do método cumprimentar (Polimorfismo)
    @Override
    public void cumprimentar() {
        super.cumprimentar(); // Usa o método da Pessoa
        System.out.println("Sou funcionário, matrícula: " + matricula);
    }
}

// 3. Classe Principal (Teste)
public class Conceito {
    public static void main(String[] args) {
        Pessoa pessoaComum = new Pessoa("Maria", 30);
        Funcionario funcionario = new Funcionario("João", 25, "F123");

        // Testando herança:
        pessoaComum.cumprimentar(); // Só diz o nome
        funcionario.cumprimentar();  // Nome + matrícula (herança + sobrescrita)
        funcionario.baterPonto();    // Método exclusivo do Funcionario

        // Polimorfismo: tratar Funcionario como Pessoa
        Pessoa pessoaGenerica = new Funcionario("Carlos", 40, "F456");
        pessoaGenerica.cumprimentar(); // Ainda chama a versão do Funcionario!
    }
}

/**
 * Conceitos-Chave:
 *     extends → Funcionario herda tudo de Pessoa.
 *     super() → Acessa o construtor/método da superclasse.
 *     @Override → Reescreve um método existente.
 *     Polimorfismo → Um Funcionario pode ser tratado como Pessoa, mas mantém seu comportamento único.
 */