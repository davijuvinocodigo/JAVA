package hashCode;

import equals.Smartphone;

public class HashCode_ {
    public static void main(String[] args) {
        equals.Smartphone s1 = new Smartphone("1ABC1", "iPhone");
        System.out.println(s1.hashCode());
    }
}
