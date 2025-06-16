package _18Abstratas;

import java.time.LocalDate;

public class Gerente extends Funcionario {
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
