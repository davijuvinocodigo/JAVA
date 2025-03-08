package equals;

/**
 *   Reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null
 *   Simétrico: para x e y diferentes de null, se x.equals(y) == true logo, y.equals(x) == true
 *   Transitividade: para x,y,z diferentes de null, se x.equals(y) == true, e x.equals(z) == true logo, y.equals(z) == true
 *   Consistente: x.equals(x) sempre retorna true se x for diferente de null
 *   para x diferente de null, x.equals(null) tem que retornar false.
 */


public class equals_02 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABC1", "iPhone");
        Smartphone s2 = new Smartphone("1ABC1", "iPhone");
        System.out.println(s1.equals(s2));


    }
}
