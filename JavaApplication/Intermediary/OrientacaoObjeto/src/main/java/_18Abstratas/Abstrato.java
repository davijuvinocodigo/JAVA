package _18Abstratas;

import java.time.LocalDate;
import java.util.List;


abstract class Funcionario {
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



class Gerente extends Funcionario {
    private String departamento;
    private int equipe;

    public Gerente(String nome, double salario, LocalDate dataAdmissao, String departamento, int equipe) {
        super(nome, salario, dataAdmissao);
        this.departamento = departamento;
        this.equipe = equipe;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getEquipe() {
        return equipe;
    }

    @Override
    public double calcularBonus() {
        // Gerentes ganham 20% de bônus + 0.5% por membro na equipe
        double bonusPorMembro = equipe * 0.005;
        return getSalario() * (0.20 + bonusPorMembro);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Gerente: " + getNome());
        System.out.println("Departamento: " + departamento);
        System.out.printf("Salário: R$ %.2f\n", getSalario());
        System.out.println("Data de admissão: " + getDataAdmissao());
        System.out.println("Tempo de empresa: " + tempoDeEmpresa() + " anos");
        System.out.println("Tamanho da equipe: " + equipe + " membros");
        System.out.printf("Bônus anual: R$ %.2f\n\n", calcularBonus());
    }
}



class Desenvolvedor extends Funcionario {
    private List<String> linguagens;

    public Desenvolvedor(String nome, double salario, LocalDate dataAdmissao, List<String> linguagens) {
        super(nome, salario, dataAdmissao);
        this.linguagens = linguagens;
    }

    public List<String> getLinguagens() {
        return linguagens;
    }

    @Override
    public double calcularBonus() {
        // Desenvolvedores ganham 10% de bônus + 1% por linguagem que dominam
        double bonusPorLinguagem = linguagens.size() * 0.01;
        return getSalario() * (0.10 + bonusPorLinguagem);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Desenvolvedor: " + getNome());
        System.out.printf("Salário: R$ %.2f\n", getSalario());
        System.out.println("Data de admissão: " + getDataAdmissao());
        System.out.println("Tempo de empresa: " + tempoDeEmpresa() + " anos");
        System.out.println("Linguagens: " + String.join(", ", linguagens));
        System.out.printf("Bônus anual: R$ %.2f\n\n", calcularBonus());
    }
}





public class Abstrato {
    public static void main(String[] args) {
        // Criando funcionários
        Desenvolvedor dev1 = new Desenvolvedor(
                "João Silva",
                8000.0,
                LocalDate.of(2020, 5, 15),
                List.of("Python", "Java", "JavaScript")
        );

        Desenvolvedor dev2 = new Desenvolvedor(
                "Maria Souza",
                9500.0,
                LocalDate.of(2019, 3, 10),
                List.of("Python", "C++", "Go", "Rust")
        );

        Gerente gerente1 = new Gerente(
                "Carlos Oliveira",
                12000.0,
                LocalDate.of(2018, 8, 22),
                "TI",
                8
        );

        // Exibindo informações
        dev1.exibirInformacoes();
        dev2.exibirInformacoes();
        gerente1.exibirInformacoes();

        // Criando um array de funcionários (demonstrando polimorfismo)
        Funcionario[] funcionarios = {dev1, dev2, gerente1};

        System.out.println("Bônus de todos os funcionários:");
        for (Funcionario func : funcionarios) {
            System.out.printf("%s: R$ %.2f\n", func.getNome(), func.calcularBonus());
        }
    }
}