package _11Associacao.Unidirecional;


class Caderno {
    private int folhas;
    private String materia;

    public Caderno(int folhas, String materia) {
        this.folhas = folhas;
        this.materia = materia;
    }

    public String getInfo() {
        return "Caderno de " + materia + " com " + folhas + " folhas";
    }
}

class Aluno {
    private String nome;
    private Caderno caderno; // Associação unidirecional

    public Aluno(String nome, Caderno caderno) {
        this.nome = nome;
        this.caderno = caderno;
    }

    public void estudar() {
        System.out.println(nome + " está estudando usando " + caderno.getInfo());
    }
}

public class Unidirecional{
    public static void main(String[] args) {
        Caderno meuCaderno = new Caderno(100, "Matemática");
        Aluno aluno = new Aluno("João", meuCaderno);

        aluno.estudar();
    }
}

/**
 * Tipo	             Exemplo              Característica Principal
 * Unidirecional	Aluno → Caderno	     Aluno conhece Caderno, mas Caderno não conhece Aluno
 */