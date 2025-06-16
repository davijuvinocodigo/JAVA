package _20Polimorfismo._01Conceito;

public class PolimorfismoDemo {
    public static void main(String[] args) {
        // Polimorfismo em ação
        Animal animal1 = new Cachorro();
        Animal animal2 = new Gato();

        // Chamadas polimórficas
        animal1.emitirSom(); // Chama a versão de Cachorro
        animal1.mover();     // Chama a versão de Cachorro

        animal2.emitirSom(); // Chama a versão de Gato
        animal2.mover();     // Chama a versão da superclasse Animal

        // Demonstração do tipo em tempo de execução
        fazerAnimalBarulho(new Cachorro());
        fazerAnimalBarulho(new Gato());
    }

    // Método que demonstra polimorfismo
    public static void fazerAnimalBarulho(Animal animal) {
        animal.emitirSom(); // Comportamento depende do tipo real do objeto

        // Verificação do tipo em tempo de execução
        if (animal instanceof Cachorro) {
            ((Cachorro) animal).abanarRabo(); // Downcasting necessário
        }
    }
}




/**
 * Polimorfismo com Sobrescrita de Métodos em Java: Introdução
 * O polimorfismo é um dos quatro pilares da Programação Orientada a Objetos (juntamente com encapsulamento, herança e abstração). Em Java, uma das formas de implementar polimorfismo é através da sobrescrita de métodos (method overriding).
 * Conceitos Fundamentais
 * 1. O que é Sobrescrita de Métodos?
 *     Ocorre quando uma subclasse fornece uma implementação específica de um método que já existe em sua superclasse
 *     Permite que uma classe filha forneça um comportamento específico para um método herdado
 * 2. Regras para Sobrescrita:
 *     O método deve ter a mesma assinatura (nome e parâmetros) que o método da superclasse
 *     O tipo de retorno deve ser o mesmo ou um subtipo (covariante)
 *     Não pode reduzir a visibilidade (ex: de public para protected)
 *     Não pode lançar exceções mais genéricas que o método original
 */

/**
 * Pontos Chave do Exemplo:
 *     Ligação Dinâmica (Dynamic Binding):
 *         Java decide em tempo de execução qual versão do método chamar, baseado no tipo real do objeto (não no tipo da referência)
 *     Uso de @Override:
 *         Boa prática para indicar sobrescrita
 *         O compilador verifica se o método realmente existe na superclasse
 *     Métodos Não Sobrescritos:
 *         Se não houver sobrescrita, a versão da superclasse é usada (como mover() para Gato)
 *     Downcasting:
 *         Necessário para acessar métodos específicos da subclasse
 *         Deve ser feito com verificação instanceof para evitar ClassCastException
 * Benefícios do Polimorfismo:
 *     Código mais flexível e extensível:
 *         Novas subclasses podem ser adicionadas sem modificar o código existente
 *     Redução de condicionais:
 *         Substitui verificações de tipo por chamadas polimórficas
 *     Princípio de substituição de Liskov:
 *         Objetos de uma superclasse podem ser substituídos por objetos de subclasses sem quebrar o programa
 *     Abstração:
 *         Permite trabalhar com conceitos genéricos (Animal) enquanto a implementação específica é tratada pelas subclasses
 * Este é o fundamento do polimorfismo em Java através da sobrescrita de métodos, que é essencial para criar sistemas orientados a objetos flexíveis e de fácil manutenção.
 */



