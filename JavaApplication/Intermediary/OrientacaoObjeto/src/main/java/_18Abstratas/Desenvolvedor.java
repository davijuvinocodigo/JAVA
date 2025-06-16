package _18Abstratas;

import java.time.LocalDate;
import java.util.List;

public class Desenvolvedor extends Funcionario {
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