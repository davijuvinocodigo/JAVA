package _14Heranca._03Generico;

enum Cargo {
    GERENTE, ANALISTA, ASSISTENTE;
}


// 1. Classe Base Genérica
class Pessoa<T> {
    private String nome;
    private int idade;
    private T informacaoEspecifica;

    public Pessoa(String nome, int idade, T informacaoEspecifica) {
        this.nome = nome;
        this.idade = idade;
        this.informacaoEspecifica = informacaoEspecifica;
    }

    public void cumprimentar() {
        System.out.println("Olá, eu sou " + nome);
    }

    public String getNome() {
        return nome;
    }

    public T getInformacaoEspecifica() {
        return informacaoEspecifica;
    }
}

// 2. Classe Derivada Genérica - HERDA de Pessoa com tipo específico
class Funcionario<C> extends Pessoa<String> {
    private C cargo;

    public Funcionario(String nome, int idade, String matricula, C cargo) {
        super(nome, idade, matricula); // Matrícula é o T (String) para Funcionario
        this.cargo = cargo;
    }

    public void baterPonto() {
        System.out.println(getNome() + " bateu o ponto (Matrícula: "
                + getInformacaoEspecifica() + ", Cargo: " + cargo + ")");
    }

    @Override
    public void cumprimentar() {
        super.cumprimentar();
        System.out.println("Sou funcionário, matrícula: " + getInformacaoEspecifica()
                + ", Cargo: " + cargo);
    }
}

// 3. Classe Principal (Teste)
public class ConceitoGenerico {
    public static void main(String[] args) {
        // Pessoa com informação específica genérica (Integer)
        Pessoa<Integer> pessoaComum = new Pessoa<>("Maria", 30, 12345);
        pessoaComum.cumprimentar();
        System.out.println("Informação específica: " + pessoaComum.getInformacaoEspecifica());

        // Funcionário com cargo como Enum
        Funcionario<String> funcionario1 = new Funcionario<>("João", 25, "F123", "Desenvolvedor");
        funcionario1.cumprimentar();
        funcionario1.baterPonto();

        // Funcionário com cargo como Enum (outro tipo)
        Funcionario<Cargo> funcionario2 = new Funcionario<>("Ana", 32, "F456", Cargo.GERENTE);
        funcionario2.cumprimentar();

        // Polimorfismo com genéricos
        Pessoa<String> pessoaGenerica = new Funcionario<>("Carlos", 40, "F789", "Diretor");
        pessoaGenerica.cumprimentar();
    }
}


/**
 *     Classe Base Genérica (Pessoa<T>):
 *         Adicionei um parâmetro de tipo genérico T
 *         Incluí um campo informacaoEspecifica do tipo T
 *         O construtor agora recebe esse valor genérico
 *     Classe Derivada Genérica (Funcionario<C>):
 *         Herda de Pessoa com tipo específico (String para matrícula)
 *         Adiciona seu próprio parâmetro genérico C para o cargo
 *         Pode trabalhar com qualquer tipo de cargo (String, Enum, etc.)
 *     Vantagens desta abordagem:
 *         Maior flexibilidade para diferentes tipos de informações
 *         Tipo segurança garantida em tempo de compilação
 *         Reutilização de código para diferentes cenários
 *         Mantém todos os benefícios de herança e polimorfismo
 *     Exemplos de uso:
 *         Pessoa com informação específica como Integer
 *         Funcionário com cargo como String
 *         Funcionário com cargo como Enum
 *         Demonstração de polimorfismo com genéricos
 * Esta implementação mostra como combinar herança tradicional com generics para criar uma hierarquia de classes mais flexível e type-safe.
 */
