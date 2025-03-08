package Consume;

import java.util.List;
import java.util.function.Consumer;

/**
 * O forEach método aceita a Consumer como parâmetro.
 * O consumidor pode ser simplificado com uma expressão lambda ou uma referência de método.
 * */

public class ConsumeBasic3Test {
    public static void main(String[] args) {

        var words = List.of("falcon", "wood", "rock", "forest",
                "river", "water");

        words.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
