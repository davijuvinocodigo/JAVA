package _06Construtores;

public class TesteCarro {
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
