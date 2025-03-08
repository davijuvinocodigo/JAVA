package FUNCOES.Strings.funcAcentuacao.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Acentuacao {
    private String titulo;
    private int numero;
    private String descricao;

    public static String value = "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïñòóôõöøùúûüýþÿatualização LTDA-S.A";


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Acentuacao(String titulo, int numero, String descricao) {
        this.titulo = titulo;
        this.numero = numero;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Acentuacao{" +
                "titulo='" + titulo + '\'' +
                ", numero=" + numero +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acentuacao that = (Acentuacao) o;
        return numero == that.numero && Objects.equals(titulo, that.titulo) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, numero, descricao);
    }

    List<Acentuacao> populaAcentuacoes(){
        Acentuacao acentuacao1 = new Acentuacao(value,1,"");
        Acentuacao acentuacao2 = new Acentuacao(value,1,"");
        Acentuacao acentuacao3 = new Acentuacao(value,1,"");
        Acentuacao acentuacao4 = new Acentuacao(value,1,"");
        Acentuacao acentuacao5 = new Acentuacao(value,1,"");
        return new ArrayList<>(Arrays.asList(acentuacao1, acentuacao2, acentuacao3, acentuacao4, acentuacao5));
    }
}
