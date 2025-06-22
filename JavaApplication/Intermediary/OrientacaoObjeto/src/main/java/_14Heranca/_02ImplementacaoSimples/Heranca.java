package _14Heranca._02ImplementacaoSimples;


// Classe Endereço (composição)
class Endereco {
    private String rua;
    private String cidade;
    private String estado;

    public Endereco(String rua, String cidade, String estado) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
    }

    // Getters
    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    // Método para exibir endereço completo
    public String getEnderecoCompleto() {
        return rua + ", " + cidade + " - " + estado;
    }
}




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




// Classe Funcionario que herda de Pessoa
class Funcionario extends Pessoa {
    private String matricula;
    private double salario;

    public Funcionario(String nome, int idade, Endereco endereco,
                       String matricula, double salario) {
        super(nome, idade, endereco); // Chama o construtor da superclasse
        this.matricula = matricula;
        this.salario = salario;
    }

    // Getters específicos de Funcionario
    public String getMatricula() {
        return matricula;
    }

    public double getSalario() {
        return salario;
    }

    // Método específico de Funcionario
    public void trabalhar() {
        System.out.println(getNome() + " está trabalhando...");
    }

    // Sobrescrita do método cumprimentar
    @Override
    public void cumprimentar() {
        super.cumprimentar(); // Chama a implementação da superclasse
        System.out.println("Sou funcionário com matrícula " + matricula);
    }
}





// Classe principal para demonstração
public class Heranca {
    public static void main(String[] args) {
        // Criando endereços
        Endereco endereco1 = new Endereco("Rua Java, 123", "São Paulo", "SP");
        Endereco endereco2 = new Endereco("Avenida OO, 456", "Rio de Janeiro", "RJ");

        // Criando pessoas e funcionários
        Pessoa pessoa = new Pessoa("Maria Silva", 30, endereco1);
        Funcionario funcionario = new Funcionario("João Santos", 35, endereco2,
                "F12345", 4500.00);

        // Demonstrando herança e polimorfismo
        System.out.println("=== Pessoa ===");
        pessoa.cumprimentar();
        System.out.println("Endereço: " + pessoa.getEndereco().getEnderecoCompleto());

        System.out.println("\n=== Funcionário ===");
        funcionario.cumprimentar(); // Método sobrescrito
        funcionario.trabalhar();    // Método específico
        System.out.println("Salário: R$ " + funcionario.getSalario());
        System.out.println("Endereço: " + funcionario.getEndereco().getEnderecoCompleto());

        // Polimorfismo: tratando Funcionario como Pessoa
        System.out.println("\n=== Polimorfismo ===");
        Pessoa pessoaFuncionario = new Funcionario("Carlos Oliveira", 28, endereco1,
                "F54321", 3800.00);
        pessoaFuncionario.cumprimentar(); // Chama a versão sobrescrita

        // Demonstração de downcasting
        if (pessoaFuncionario instanceof Funcionario) {
            Funcionario func = (Funcionario) pessoaFuncionario;
            func.trabalhar();
        }
    }
}


/**
 * Conceitos Demonstrados:
 *     Herança:
 *         Funcionario herda de Pessoa (relação "é-um")
 *         Reutilização de código (atributos e métodos da superclasse)
 *         Uso de super para acessar membros da superclasse
 *     Composição:
 *         Pessoa tem um Endereco (relação "tem-um")
 *         Melhor alternativa quando não há relação de herança
 *     Polimorfismo:
 *         Sobrescrita do método cumprimentar()
 *         Variável do tipo Pessoa referenciando um objeto Funcionario
 *     Encapsulamento:
 *         Atributos privados com métodos públicos de acesso (getters)
 *         Controle sobre como os dados são acessados e modificados
 *     Downcasting:
 *         Conversão explícita de Pessoa para Funcionario quando necessário
 * Boas Práticas Demonstradas:
 *     Uso correto de herança:
 *         Apenas quando há uma relação "é-um" genuína
 *         Funcionário é um tipo específico de Pessoa
 *     Preferência por composição:
 *         Endereço é uma entidade separada composta em Pessoa
 *         Mais flexível que herança para casos sem relação "é-um"
 *     Sobrescrita de métodos:
 *         Usando @Override para maior clareza
 *         Chamando a implementação da superclasse com super quando apropriado
 *     Polimorfismo:
 *         Capacidade de tratar objetos especializados como genéricos
 *         Manutenção mais fácil e código mais flexível
 * Este exemplo mostra como aplicar corretamente herança em Java, combinando com outros conceitos importantes como composição e polimorfismo para criar um design orientado a objetos robusto.
 */