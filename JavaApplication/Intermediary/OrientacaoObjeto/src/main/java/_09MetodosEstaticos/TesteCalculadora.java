package _09MetodosEstaticos;

class Calculadora {
    // Atributo estático (compartilhado por todas as instâncias)
    private static int contadorUso = 0;

    // Método estático
    public static double somar(double a, double b) {
        contadorUso++;
        return a + b;
    }

    public static double subtrair(double a, double b) {
        contadorUso++;
        return a - b;
    }

    // Método estático que acessa outro método estático
    public static double calcularMedia(double[] numeros) {
        if (numeros == null || numeros.length == 0) {
            return 0;
        }
        double soma = 0;
        for (double num : numeros) {
            soma = somar(soma, num); // Chamando outro método estático
        }
        return dividir(soma, numeros.length);
    }

    private static double dividir(double a, double b) {
        contadorUso++;
        if (b == 0) throw new ArithmeticException("Divisão por zero");
        return a / b;
    }

    // Método estático para acessar atributo estático
    public static int getContadorUso() {
        return contadorUso;
    }

    // Método de instância que acessa membro estático
    public String getInfoUso() {
        return "Calculadora usada " + contadorUso + " vezes";
    }
}

// Classe de teste
public class TesteCalculadora {
    public static void main(String[] args) {
        // Chamando métodos estáticos sem instanciar a classe
        System.out.println("Soma: " + Calculadora.somar(5, 3));
        System.out.println("Subtração: " + Calculadora.subtrair(5, 3));

        double[] valores = {10, 20, 30, 40};
        System.out.println("Média: " + Calculadora.calcularMedia(valores));

        // Acessando atributo estático através de método estático
        System.out.println("Total de operações: " + Calculadora.getContadorUso());

        // Criando instância para demonstrar método de instância
        Calculadora calc = new Calculadora();
        System.out.println(calc.getInfoUso());
    }
}

/**
 * Os métodos estáticos (static) em Java são membros de uma classe que não operam em instâncias específicas, mas sim pertencem à classe como um todo. Eles têm características especiais no contexto da orientação a objetos.
 * Características dos métodos estáticos:
 *     Pertencem à classe, não a instâncias
 *     Não podem acessar membros de instância diretamente (não têm acesso ao this)
 *     Podem ser chamados sem criar uma instância da classe
 */


/**
 * Quando usar métodos estáticos:
 *     Métodos utilitários (como a classe Math do Java)
 *     Métodos de fábrica (factory methods)
 *     Métodos que não dependem do estado do objeto
 *     Funções auxiliares que operam apenas sobre seus parâmetros
 * Cuidados com métodos estáticos:
 *     Não são polimórficos - não podem ser sobrescritos (embora possam ser ocultados)
 *     Dificultam o teste unitário quando usados indiscriminadamente
 *     Podem levar a acoplamento excessivo se usados em excesso
 */
