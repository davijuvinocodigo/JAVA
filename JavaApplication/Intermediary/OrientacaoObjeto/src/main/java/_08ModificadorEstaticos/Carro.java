package _08ModificadorEstaticos;

public class Carro {
    // Atributos de instância
    private final String modelo;
    private final String placa;
    private int velocidadeAtual;

    // Atributos estáticos (compartilhados por todos os carros)
    private static int totalCarrosProduzidos = 0;
    private static int velocidadeLimite = 120; // km/h (compartilhado por todos)

    // Constante estática
    public static final String FABRICANTE = "Java Motors";

    // TesteCarro
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
