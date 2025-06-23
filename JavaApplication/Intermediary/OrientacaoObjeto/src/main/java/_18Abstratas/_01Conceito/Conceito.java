package _18Abstratas._01Conceito;


abstract class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // Método concreto (já implementado)
    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    // Método abstrato (as subclasses precisam implementar)
    public abstract double calcularBonus();
}

class Gerente extends Funcionario {
    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return getSalario() * 0.20; // Bônus de 20%
    }
}

class Programador extends Funcionario {
    public Programador(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return getSalario() * 0.15; // Bônus de 15%
    }
}



public class Conceito {
    public static void main(String[] args) {
        Funcionario[] equipe = {
                new Gerente("Ana", 10000),
                new Programador("João", 5000)
        };

        for (Funcionario f : equipe) {
            System.out.println(f.getNome() + " - Bônus: " + f.calcularBonus());
        }
    }
}
