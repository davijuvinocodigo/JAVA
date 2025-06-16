package _20Polimorfismo._03ClassesFinal;

// Classe final - não pode ser estendida
final class AnimalDomestico {
    private String nome;
    private String dono;

    public AnimalDomestico(String nome, String dono) {
        this.nome = nome;
        this.dono = dono;
    }

    public void alimentar() {
        System.out.println(nome + " está sendo alimentado por " + dono);
    }

    public void brincar() {
        System.out.println(nome + " está brincando com " + dono);
    }

    // Método final - não pode ser sobrescrito
    public final void vacinar() {
        System.out.println(nome + " foi vacinado");
    }
}

// Tentativa de herança (geraria erro de compilação)
/*
class CachorroDomestico extends AnimalDomestico {  // Erro: Cannot inherit from final AnimalDomestico
    // Implementação...
}
*/

// Classe separada que usa AnimalDomestico (sem herança)
class DonoAnimal {
    private AnimalDomestico animal;

    public DonoAnimal(AnimalDomestico animal) {
        this.animal = animal;
    }

    public void cuidarDoAnimal() {
        animal.alimentar();
        animal.brincar();
        animal.vacinar();
    }
}

// Exemplo de uso
public class ExemploFinal {
    public static void main(String[] args) {
        AnimalDomestico meuPet = new AnimalDomestico("Rex", "João");

        meuPet.alimentar();  // Rex está sendo alimentado por João
        meuPet.brincar();    // Rex está brincando com João
        meuPet.vacinar();    // Rex foi vacinado

        // Usando a classe DonoAnimal
        DonoAnimal dono = new DonoAnimal(meuPet);
        dono.cuidarDoAnimal();
        
        /*
        Saída:
        Rex está sendo alimentado por João
        Rex está brincando com João
        Rex foi vacinado
        */
    }
}