package _06Construtores;

public class Construtor {

    private String tipo;
    private int epsodios;
    private String nome;
    private String genero;

    public Construtor() {
    }

    public Construtor(String tipo, int epsodios, String nome) {
        this.tipo = tipo;
        this.epsodios = epsodios;
        this.nome = nome;
    }

    //chamando contrutores com novo atributo
    public Construtor(String tipo, int epsodios, String nome, String genero) {
        this(tipo, epsodios, nome);
        this.genero = genero;
    }
}
