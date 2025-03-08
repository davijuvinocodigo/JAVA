package Reference.Constructor;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Podemos usar o construtor para criar uma expressão lambda.
 *
 * A sintaxe para usar uma referência de construtor é
 *
 * ClassName::new
 *
 * A palavra-chave new refere-se ao construtor da classe.
 * O compilador escolhe um construtor com base no contexto.
 * */
public class ConstructorReferenceBasicTest {
    public static void main(String[] argv){
        Supplier<String> func1  = () ->  new String();
        System.out.println("Empty String:"+func1.get());

        Function<String,String> func2  = str ->  new String(str);
        System.out.println(func2.apply("java2s.com"));

        Supplier<String> func3  = String::new;
        System.out.println("Empty String:"+func3.get());

        Function<String,String> func4  = String::new;
        System.out.println(func4.apply("java2s.com"));
    }
}
