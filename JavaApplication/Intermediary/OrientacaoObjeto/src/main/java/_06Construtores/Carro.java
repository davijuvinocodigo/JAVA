package _06Construtores;

public class Carro {
    private String modelo;
    private String cor;
    private int ano;
    private double velocidade;

    // 1. Construtor padrão
    public Carro() {
        this.modelo = "Desconhecido";
        this.cor = "Branco";
        this.ano = 2023;
        this.velocidade = 0;
    }

    // 2. Construtor com parâmetros básicos
    public Carro(String modelo, int ano) {
        this(); // Chama o construtor padrão
        this.modelo = modelo;
        this.ano = ano;
    }

    // 3. Construtor completo
    public Carro(String modelo, String cor, int ano, double velocidade) {
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.velocidade = velocidade;
    }

    // 4. Construtor de cópia
    public Carro(Carro outroCarro) {
        this(outroCarro.modelo, outroCarro.cor, outroCarro.ano, outroCarro.velocidade);
    }

    // Métodos de instância
    public void acelerar(double incremento) {
        this.velocidade += incremento;
    }

    public void frear(double decremento) {
        this.velocidade = Math.max(0, this.velocidade - decremento);
    }

    @Override
    public String toString() {
        return String.format("Carro: %s, Cor: %s, Ano: %d, Velocidade: %.1f km/h",
                modelo, cor, ano, velocidade);
    }
}