package _14Heranca;

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
