package Consume;

import java.util.function.Consumer;

public class ConsumeImpl1Test {
    public static void main(String[] args) {
        int x = 99;

        Consumer<Integer> myConsumer = (y) -> {
            System.out.println("x = " + x); // Statement A
            System.out.println("y = " + y);
        };

        myConsumer.accept(x);
    }
}
