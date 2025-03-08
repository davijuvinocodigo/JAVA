package _13AssociacaoSeminario;

public class Run {
    public static void main(String[] args) {
        Local local = new Local("Rua das laranjeiras");
        Aluno aluno = new Aluno("Luffy", 17);
        Professor professor = new Professor("Barba Branca", "Pirata");
        Aluno[] alunosParaSeminario = {};

        Seminario seminario = new Seminario("Onde achar one piece", alunosParaSeminario, local);

        Seminario[] seminariosParaProfessor = {seminario};

        professor.setSeminarios(seminariosParaProfessor);

        professor.imprime();
    }
}
