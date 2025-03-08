package Consume;

import java.util.function.Consumer;

/**
 * A interface do consumidor representa uma operação que aceita um único argumento
 * de entrada e não retorna nenhum resultado.
 * */
public class ConsumeBasic1Test {
    public static void main(String[] args) {
        Consumer c1 = (Object obj) -> {
            System.out.println(obj);
        };
        Consumer c2 = obj -> System.out.println(obj);
        Consumer<String> c3 = (x) -> System.out.println(x.toLowerCase());

        c1.accept("Hello World");
        c2.accept("Hello World");
        c3.accept("JAVA2S.COM");
    }
}
