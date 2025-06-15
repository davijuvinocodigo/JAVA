package _14Heranca._04Contrutores;

/**
 Herança: A classe Funcionario estende a classe Pessoa, o que significa que ela herda os atributos e métodos de Pessoa.
 Construtor da classe base: O uso de super(nome) no construtor de Funcionario garante que o atributo nome da classe Pessoa seja inicializado corretamente.
 Inicialização: Quando um objeto da classe Funcionario é criado, o construtor de Pessoa é chamado primeiro para configurar os atributos herdados, antes de executar o código específico de Funcionario.
 Isso é necessário porque a classe base (Pessoa) possui um construtor que exige um parâmetro (nome), e o Java não fornece um construtor padrão automaticamente quando há um construtor definido explicitamente.
 */
public class Funcionario extends Pessoa {
    private double salario;

    public Funcionario(String nome) {
        super(nome);
    }

    public void imprime() {
        super.imprime();
        System.out.println(this.salario);
    }

    public void relatorioPagamento() {
        System.out.println("Eu " + this.nome + " recevi o salario de " + this.salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
