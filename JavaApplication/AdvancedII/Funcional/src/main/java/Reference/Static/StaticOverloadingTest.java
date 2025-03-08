package Reference.Static;


import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Referências de métodos estáticos em sobrecarga
 * Podemos usar o método estático sobrecarregado na referência do método estático.
 *
 * Quando o método está sobrecarregado, devemos prestar mais atenção à assinatura do método e à interface funcional correspondente.
 *
 * Na lista a seguir temos três versões do valueOf() da classe Integer.
 *
 * static Integer valueOf(int i)
 * static Integer valueOf(String s)
 * static Integer valueOf(String s, int radix)
 *
 * O código a seguir mostra como diferentes interfaces funcionais de destino
 * podem ser usadas com os métodos estáticos Integer.valueOf() sobrecarregados.
 *
 * */
public class StaticOverloadingTest {
    public static void main(String[] argv){
        // Uses  Integer.valueOf(int)
        Function<Integer, Integer> func1  = Integer::valueOf;

        // Uses  Integer.valueOf(String)
        Function<String, Integer> func2  = Integer::valueOf;

        // Uses  Integer.valueOf(String, int)
        BiFunction<String, Integer,  Integer> func3  = Integer::valueOf;

        System.out.println(func1.apply(7));
        System.out.println(func2.apply("7"));
        System.out.println(func3.apply("101010101010", 2));
    }
}
