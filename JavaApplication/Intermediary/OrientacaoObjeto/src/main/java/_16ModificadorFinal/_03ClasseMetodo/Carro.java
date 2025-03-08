package _16ModificadorFinal._03ClasseMetodo;

public class Carro {
    private String nome;
    public static final double VELOCIDADE_LIMITE = 250;

    // Esse metodo quer dizer que não será sobrescrito
    public final void imprimir(){
        System.out.println(this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
