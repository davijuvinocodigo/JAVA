package _08ModificadorEstaticos;

public class TesteCarro {
    public static void main(String[] args) {
        // Acessando constante estática
        System.out.println("Fabricante: " + Carro.FABRICANTE);

        // Criando carros
        Carro carro1 = new Carro("Sedan", "ABC-1234");
        Carro carro2 = new Carro("Hatch", "XYZ-9876");

        // Usando método estático de fábrica
        Carro carroEsportivo = Carro.criarCarroEsportivo("ESP-2023");

        // Operações com os carros
        carro1.acelerar(80);
        carro2.acelerar(100);
        carroEsportivo.acelerar(150);

        // Exibindo informações
        System.out.println("\nInformações dos carros:");
        System.out.println(carro1);
        System.out.println(carro2);
        System.out.println(carroEsportivo);

        // Alterando o limite de velocidade para todos os carros via método estático
        Carro.alterarVelocidadeLimite(110);

        // Tentando acelerar além do novo limite
        carro1.acelerar(50);
        System.out.println("\nApós tentativa de acelerar além do limite:");
        System.out.println(carro1);

        // Acessando atributo estático
        System.out.println("\nTotal de carros produzidos: " + Carro.getTotalCarrosProduzidos());
    }
}

/**
 * Principais Pontos Demonstrados:
 *     Atributo estático (totalCarrosProduzidos): Contador compartilhado por todas as instâncias
 *     Constante estática (FABRICANTE): Valor imutável e compartilhado
 *     Método estático (alterarVelocidadeLimite): Altera um valor compartilhado por todos os carros
 *     Método estático de fábrica (criarCarroEsportivo): Padrão de projeto para criação especializada
 *     Atributo estático mutável (velocidadeLimite): Valor compartilhado que pode ser alterado
 *     Acesso a membros estáticos a partir de métodos de instância (no método getInfo)
 * Este exemplo mostra como os membros estáticos podem ser usados para representar características compartilhadas por todas as instâncias de uma classe, enquanto mantemos os princípios da orientação a objetos.
 */
