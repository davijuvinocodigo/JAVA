package _20Polimorfismo._04Interfaces;

// Interface para animais que emitem som
interface AnimalQueFazSom {
    void emitirSom();
}

// Interface para animais que podem se mover
interface AnimalQueSeMove {
    void mover();
}

// Interface para animais de estimação
interface AnimalDeEstimacao {
    void brincar();
    void setDono(String dono);
}

// Classe Cachorro que implementa múltiplas interfaces
class Cachorro implements AnimalQueFazSom, AnimalQueSeMove, AnimalDeEstimacao {
    private String nome;
    private String dono;

    public Cachorro(String nome) {
        this.nome = nome;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " diz: Au au!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está correndo com suas 4 patas");
    }

    @Override
    public void brincar() {
        System.out.println(nome + " está brincando com " + dono);
    }

    @Override
    public void setDono(String dono) {
        this.dono = dono;
    }

    // Método específico de Cachorro
    public void abanarRabo() {
        System.out.println(nome + " está abanando o rabo!");
    }
}

// Classe Passaro que implementa interfaces
class Passaro implements AnimalQueFazSom, AnimalQueSeMove {
    private String nome;
    private String especie;

    public Passaro(String nome, String especie) {
        this.nome = nome;
        this.especie = especie;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " (" + especie + ") diz: Piu piu!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está voando pelos ares");
    }

    // Método específico de Passaro
    public void construirNinho() {
        System.out.println(nome + " está construindo um ninho");
    }
}

// Classe Peixe que implementa interfaces
class Peixe implements AnimalQueSeMove {
    private String nome;
    private String tipoAgua;

    public Peixe(String nome, String tipoAgua) {
        this.nome = nome;
        this.tipoAgua = tipoAgua;
    }

    @Override
    public void mover() {
        System.out.println(nome + " está nadando na água " + tipoAgua);
    }

    // Método específico de Peixe
    public void bolhas() {
        System.out.println(nome + " está soltando bolhas");
    }
}

// Classe principal para demonstração
public class ZoologicoInterfaces {
    public static void main(String[] args) {
        // Criando animais
        AnimalQueFazSom[] animaisQueFazemSom = {
                new Cachorro("Rex"),
                new Passaro("Piu", "Canário")
        };

        AnimalQueSeMove[] animaisQueSeMovem = {
                new Cachorro("Rex"),
                new Passaro("Piu", "Canário"),
                new Peixe("Nemo", "salgada")
        };

        // Demonstrando polimorfismo com interfaces
        System.out.println("=== Sons dos Animais ===");
        for (AnimalQueFazSom animal : animaisQueFazemSom) {
            animal.emitirSom();
        }

        System.out.println("\n=== Movimento dos Animais ===");
        for (AnimalQueSeMove animal : animaisQueSeMovem) {
            animal.mover();
        }

        // Trabalhando com AnimalDeEstimacao
        Cachorro cachorro = new Cachorro("Toby");
        cachorro.setDono("Maria");
        System.out.println("\n=== Atividades com Animal de Estimação ===");
        cachorro.brincar();
        cachorro.abanarRabo();

        // Demonstração adicional
        fazerAnimalMover(new Cachorro("Lucky"));
        fazerAnimalMover(new Peixe("Dory", "doce"));
    }

    // Método que demonstra polimorfismo com interface
    public static void fazerAnimalMover(AnimalQueSeMove animal) {
        System.out.println("\nIniciando movimento:");
        animal.mover();

        // Verificando o tipo real do objeto
        if (animal instanceof Cachorro) {
            ((Cachorro) animal).abanarRabo();
        } else if (animal instanceof Peixe) {
            ((Peixe) animal).bolhas();
        }
    }
}
