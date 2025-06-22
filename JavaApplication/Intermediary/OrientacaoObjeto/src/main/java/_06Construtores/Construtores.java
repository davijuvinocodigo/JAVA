package _06Construtores;



class Carro {
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




public class Construtores {
    public static void main(String[] args) {
        // Usando construtor padrão
        Carro carro1 = new Carro();
        System.out.println(carro1);

        // Usando construtor com parâmetros básicos
        Carro carro2 = new Carro("Fusca", 1970);
        carro2.acelerar(50);
        System.out.println(carro2);

        // Usando construtor completo
        Carro carro3 = new Carro("Ferrari", "Vermelha", 2023, 0);
        carro3.acelerar(120);
        System.out.println(carro3);

        // Usando construtor de cópia
        Carro carro4 = new Carro(carro3);
        carro4.frear(30);
        System.out.println("Cópia: " + carro4);
        System.out.println("Original: " + carro3);
    }
}

/**
 * Boas Práticas com Construtores
 *     Encadeamento de construtores: Use this() para chamar outros construtores da mesma classe
 *     Validação de parâmetros: Valide os argumentos recebidos
 *     Inicialização completa: Garanta que todos os campos importantes sejam inicializados
 *     Documentação: Use JavaDoc para documentar o propósito de cada construtor
 */
