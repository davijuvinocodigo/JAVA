package _11Associacao.Composicao;


import java.util.ArrayList;
import java.util.List;

class Componente {
    private String nome;
    private String especificacao;

    public Componente(String nome, String especificacao) {
        this.nome = nome;
        this.especificacao = especificacao;
    }

    public String getInfo() {
        return nome + " (" + especificacao + ")";
    }
}

class Computador {
    private String marca;
    private String modelo;
    private List<Componente> componentes;

    public Computador(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.componentes = new ArrayList<>();
        // Componentes são criados com o computador
        this.componentes.add(new Componente("CPU", "Intel i7"));
        this.componentes.add(new Componente("RAM", "16GB DDR4"));
        this.componentes.add(new Componente("HD", "1TB SSD"));
    }

    public void ligar() {
        System.out.println("Ligando computador " + marca + " " + modelo);
        System.out.println("Componentes:");
        componentes.forEach(c -> System.out.println("- " + c.getInfo()));
    }

    // Componentes não podem existir sem o computador
    public void substituirComponente(int index, Componente novo) {
        if (index >= 0 && index < componentes.size()) {
            componentes.set(index, novo);
        }
    }
}

public class Composicao {
    public static void main(String[] args) {
        Computador meuPC = new Computador("Dell", "XPS 15");
        meuPC.ligar();

        // Substituindo um componente
        meuPC.substituirComponente(1, new Componente("RAM", "32GB DDR4"));
        System.out.println("\nApós upgrade:");
        meuPC.ligar();
    }
}

/**
 *   Tipo	     Exemplo	                Característica Principal
 * Composição	Computador ⊕ Componentes	Componentes não existem sem o computador
 */
