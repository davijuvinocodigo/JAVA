package _11Associacao.Agregacao;


import java.util.ArrayList;
import java.util.List;

class Professor {
    private String nome;
    private String disciplina;

    public Professor(String nome, String disciplina) {
        this.nome = nome;
        this.disciplina = disciplina;
    }

    public String getNome() {
        return nome;
    }

    public void ministrarAula() {
        System.out.println("Prof. " + nome + " ministrando aula de " + disciplina);
    }
}

class Universidade {
    private String nome;
    private List<Professor> professores;

    public Universidade(String nome) {
        this.nome = nome;
        this.professores = new ArrayList<>();
    }

    public void contratarProfessor(Professor professor) {
        professores.add(professor);
        System.out.println(professor.getNome() + " contratado pela " + nome);
    }

    public void demitirProfessor(Professor professor) {
        professores.remove(professor);
        System.out.println(professor.getNome() + " demitido da " + nome);
    }

    public void listarProfessores() {
        System.out.println("Corpo docente da " + nome + ":");
        professores.forEach(p -> System.out.println("- " + p.getNome()));
    }
}

public class Agregacao {
    public static void main(String[] args) {
        Universidade ufmg = new Universidade("UFMG");

        Professor prof1 = new Professor("Ana", "Matemática");
        Professor prof2 = new Professor("Carlos", "Física");

        ufmg.contratarProfessor(prof1);
        ufmg.contratarProfessor(prof2);

        ufmg.listarProfessores();

        // Professor continua existindo sem a universidade
        ufmg.demitirProfessor(prof1);
        prof1.ministrarAula(); // Professor independente
    }
}

/**
 *   Tipo	     Exemplo	                 Característica Principal
 * Agregação	Universidade ⊖ Professor	Professores existem independentemente da universidade
 */
