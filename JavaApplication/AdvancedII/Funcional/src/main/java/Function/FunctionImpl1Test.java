package Function;

import java.util.function.Function;

/**
 * A interface Function<T, R> é uma interface funcional do pacote java.util.function.
 * Essa interface espera um argumento como entrada e produz um resultado.
 * A interface Function<T, R> pode ser usada como um destino de atribuição para uma expressão
 * lambda  ou referência de método  .
 * Ele contém um método abstrato:
 * apply() ,
 * dois métodos padrão: andThen() e compose()
 * e um método estático: identity() .
 * */
public class FunctionImpl1Test {
    public static void main(String[] args)  {

        String result = calc((a) -> "Result: " + (a * 2), 10);
        System.out.println(result);

    }
    public static String calc(Function<Integer, String> bi, Integer i) {
        return bi.apply(i);
    }
}
