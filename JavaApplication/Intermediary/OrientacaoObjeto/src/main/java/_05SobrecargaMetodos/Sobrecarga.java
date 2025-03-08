package _05SobrecargaMetodos;

public class Sobrecarga {

    private String tipo;
    private int epsodios;
    private String nome;
    private String genero;

    public void init(String tipo, int epsodios, String nome){
        this.nome = nome;
        this.epsodios = epsodios;
        this.tipo = tipo;
    }

    public void init(String tipo, int epsodios, String nome, String genero){
        this.init(tipo,epsodios,nome);
        this.genero = genero;

    }

    // sobrecarga chamar o mesmo metodo com o novo atributo
}
