package _20Polimorfismo._02ClassesAbstrata;

// Classe principal para demonstração
public class Zoologico {
    public static void main(String[] args) {
        // Criando animais (polimorfismo)
        Animal[] animais = {
                new Cachorro("Rex", 3, "Labrador"),
                new Gato("Mimi", 2, true),
                new Passaro("Piu", 1, "Amarelo")
        };

        // Demonstrando polimorfismo
        for (Animal animal : animais) {
            System.out.println("\n--- " + animal.getNome() + " (" + animal.getClass().getSimpleName() + ") ---");

            // Chamadas polimórficas
            animal.emitirSom();
            animal.mover();
            animal.dormir();

            // Chamando métodos específicos com verificação de tipo
            if (animal instanceof Cachorro) {
                ((Cachorro) animal).abanarRabo();
            } else if (animal instanceof Gato) {
                ((Gato) animal).arranhar();
            } else if (animal instanceof Passaro) {
                ((Passaro) animal).construirNinho();
            }
        }

        // Demonstração adicional
        alimentarAnimal(new Cachorro("Toby", 4, "Vira-lata"));
        alimentarAnimal(new Passaro("Loro", 2, "Verde"));
    }

    // Método que demonstra polimorfismo com parâmetro abstrato
    public static void alimentarAnimal(Animal animal) {
        System.out.println("\nAlimentando " + animal.getNome());
        animal.emitirSom(); // Comportamento específico para cada animal

        if (animal instanceof Cachorro) {
            System.out.println("Dando ração para cachorro");
        } else if (animal instanceof Gato) {
            System.out.println("Dando ração para gato");
        } else if (animal instanceof Passaro) {
            System.out.println("Colocando sementes no comedouro");
        }
    }
}


/**
 * Análise do Exemplo:
 *     Classe Abstrata AnimalDomestico:
 *         Define atributos comuns (nome, idade)
 *         Declara métodos abstratos que todas as subclasses devem implementar (emitirSom, mover)
 *         Fornece implementação concreta para métodos comuns (dormir)
 *    Polimorfismo:
 *         O array AnimalDomestico[] pode conter qualquer subclasse de AnimalDomestico
 *         As chamadas emitirSom() e mover() são resolvidas em tempo de execução
 *         O método alimentarAnimal() aceita qualquer tipo de AnimalDomestico
 *     Métodos Específicos:
 *         Cada subclasse pode ter métodos próprios (abanarRabo, arranhar, construirNinho)
 *         Uso de instanceof para verificação de tipo antes de fazer downcasting
 *     Extensibilidade:
 *         Fácil adicionar novos tipos de animais criando novas subclasses
 *         O código existente não precisa ser modificado para adicionar novos animais
 * Benefícios desta Implementação:
 *     Abstração: Esconde detalhes de implementação das subclasses
 *     Reuso de código: Métodos comuns na superclasse evitam duplicação
 *     Flexibilidade: Novos comportamentos podem ser adicionados sem modificar código existente
 *     Organização: Hierarquia clara de classes com responsabilidades bem definidas
 * Este exemplo demonstra como usar classes abstratas em Java para modelar um sistema de animais com polimorfismo, seguindo boas práticas de orientação a objetos.
 */