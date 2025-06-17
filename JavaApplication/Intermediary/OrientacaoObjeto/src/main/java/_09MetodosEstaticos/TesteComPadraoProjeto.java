package _09MetodosEstaticos;



abstract class FormaGeometrica {
    // Método estático de fábrica
    public static FormaGeometrica criarForma(String tipo, double... parametros) {
        return switch (tipo.toLowerCase()) {
            case "circulo" -> new Circulo(parametros[0]);
            case "retangulo" -> new Retangulo(parametros[0], parametros[1]);
            case "quadrado" -> new Quadrado(parametros[0]);
            default -> throw new IllegalArgumentException("Forma desconhecida: " + tipo);
        };
    }

    public abstract double calcularArea();
}

class Circulo extends FormaGeometrica {
    private final double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}

class Retangulo extends FormaGeometrica {
    private final double largura, altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }
}

class Quadrado extends Retangulo {
    public Quadrado(double lado) {
        super(lado, lado);
    }
}

// Uso do método estático de fábrica
public class TesteComPadraoProjeto {
    public static void main(String[] args) {
        FormaGeometrica circulo = FormaGeometrica.criarForma("circulo", 5.0);
        FormaGeometrica retangulo = FormaGeometrica.criarForma("retangulo", 4.0, 6.0);

        System.out.println("Área do círculo: " + circulo.calcularArea());
        System.out.println("Área do retângulo: " + retangulo.calcularArea());
    }
}

/**
 *   Neste exemplo avançado, usamos um método estático como factory method para criar instâncias de diferentes formas geométricas,
 *   demonstrando um bom uso de métodos estáticos no contexto da orientação a objetos.
 */

