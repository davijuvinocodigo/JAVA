package Reference.Static;

import java.util.function.BiFunction;

public class StaticBiFunction2Test {
    public static void main(String[] argv) {

        // Uses a lambda expression
        BiFunction<Integer, Integer, Integer> func1 = (x, y) -> Integer.sum(x, y);
        System.out.println(func1.apply(2, 3));

        // Uses a method reference
        BiFunction<Integer, Integer, Integer> func2 = Integer::sum;
        System.out.println(func2.apply(2, 3));

    }
}
