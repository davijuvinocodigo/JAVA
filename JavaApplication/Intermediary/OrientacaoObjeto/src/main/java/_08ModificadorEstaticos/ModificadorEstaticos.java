package _08ModificadorEstaticos;


class Carro {
    // Atributos de instância
    private final String modelo;
    private final String placa;
    private int velocidadeAtual;

    // Atributos estáticos (compartilhados por todos os carros)
    private static int totalCarrosProduzidos = 0;
    private static int velocidadeLimite = 120; // km/h (compartilhado por todos)

    // Constante estática
    public static final String FABRICANTE = "Java Motors";

    // ModificadorEstaticos
    public Carro(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
        this.velocidadeAtual = 0;
        totalCarrosProduzidos++; // Incrementa o contador estático
    }

    // Métodos de instância
    public void acelerar(int incremento) {
        if (this.velocidadeAtual + incremento > velocidadeLimite) {
            this.velocidadeAtual = velocidadeLimite;
            System.out.println("Limite de velocidade atingido!");
        } else {
            this.velocidadeAtual += incremento;
        }
    }

    public void frear(int decremento) {
        if (this.velocidadeAtual - decremento < 0) {
            this.velocidadeAtual = 0;
        } else {
            this.velocidadeAtual -= decremento;
        }
    }

    // Métodos estáticos
    public static void alterarVelocidadeLimite(int novaVelocidade) {
        if (novaVelocidade > 0) {
            velocidadeLimite = novaVelocidade;
            System.out.println("Novo limite de velocidade definido: " + novaVelocidade + " km/h");
        }
    }

    public static int getTotalCarrosProduzidos() {
        return totalCarrosProduzidos;
    }

    // Método estático de fábrica
    public static Carro criarCarroEsportivo(String placa) {
        Carro esportivo = new Carro("Esportivo", placa);
        alterarVelocidadeLimite(200); // Carros esportivos têm limite maior
        return esportivo;
    }

    // Métodos de instância que acessam membros estáticos
    public String getInfo() {
        return String.format(
                "Carro %s, placa %s, velocidade %d km/h (Limite: %d km/h) - Fabricante: %s",
                modelo, placa, velocidadeAtual, velocidadeLimite, FABRICANTE
        );
    }

    @Override
    public String toString() {
        return getInfo();
    }
}




public class ModificadorEstaticos {
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
