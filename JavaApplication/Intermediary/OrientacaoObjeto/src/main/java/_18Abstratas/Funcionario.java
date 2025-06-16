package _18Abstratas;

import java.time.LocalDate;

public abstract class Funcionario {
    private String nome;
    private double salario;
    private LocalDate dataAdmissao;

    public Funcionario(String nome, double salario, LocalDate dataAdmissao) {
        this.nome = nome;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    // Método abstrato que deve ser implementado pelas subclasses
    public abstract double calcularBonus();

    // Método abstrato para exibir informações específicas do cargo
    public abstract void exibirInformacoes();

    // Método concreto que pode ser usado por todas as subclasses
    public int tempoDeEmpresa() {
        return LocalDate.now().getYear() - dataAdmissao.getYear();
    }
}
