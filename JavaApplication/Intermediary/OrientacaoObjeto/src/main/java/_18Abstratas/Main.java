package _18Abstratas;

import java.time.LocalDate;
import java.util.List;

public class Main {
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