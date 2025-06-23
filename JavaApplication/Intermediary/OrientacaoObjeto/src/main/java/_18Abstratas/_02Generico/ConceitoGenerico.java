package _18Abstratas._02Generico;


abstract class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public abstract double calcularBonus();
}

class Gerente extends Funcionario {
    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return getSalario() * 0.20;
    }
}

class Programador extends Funcionario {
    public Programador(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return getSalario() * 0.15;
    }
}

// Classe genérica para processamento de funcionários
class ProcessadorFuncionarios<T extends Funcionario> {
    private T[] funcionarios;

    public ProcessadorFuncionarios(T[] funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void imprimirBonificacoes() {
        for (T funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - Bônus: " + funcionario.calcularBonus());
        }
    }

    public double calcularTotalBonificacoes() {
        double total = 0;
        for (T funcionario : funcionarios) {
            total += funcionario.calcularBonus();
        }
        return total;
    }
}

public class ConceitoGenerico {
    public static void main(String[] args) {
        Funcionario[] equipe = {
                new Gerente("Ana", 10000),
                new Programador("João", 5000),
                new Programador("Maria", 6000)
        };

        // Usando a classe genérica
        ProcessadorFuncionarios<Funcionario> processador = new ProcessadorFuncionarios<>(equipe);

        System.out.println("Bonificações da equipe:");
        processador.imprimirBonificacoes();

        System.out.println("\nTotal de bonificações: " + processador.calcularTotalBonificacoes());

        // Exemplo com um tipo específico (apenas Gerentes)
        Gerente[] gerentes = {
                new Gerente("Carlos", 12000),
                new Gerente("Patricia", 15000)
        };

        ProcessadorFuncionarios<Gerente> processadorGerentes = new ProcessadorFuncionarios<>(gerentes);
        System.out.println("\nBonificações dos gerentes:");
        processadorGerentes.imprimirBonificacoes();
    }
}
