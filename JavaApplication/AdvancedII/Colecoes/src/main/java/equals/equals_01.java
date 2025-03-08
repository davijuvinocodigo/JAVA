package equals;

/**
 * Equals comparando objetos deferentes porem com o mesmo valor.
 * O retorno será false, porque objetos nunca são iguais.
 *
 */
public class equals_01 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABC1", "iPhone");
        Smartphone s2 = new Smartphone("1ABC1", "iPhone");
        System.out.println(s1.equals(s2));
    }
}
