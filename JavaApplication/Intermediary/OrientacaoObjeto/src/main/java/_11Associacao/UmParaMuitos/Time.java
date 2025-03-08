package _11Associacao.UmParaMuitos;

// Unidirecional (1 - N)
public class Time {

    private String nome;

    public Time(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
