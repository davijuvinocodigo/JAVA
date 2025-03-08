package Predicate;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 *  https://www.java67.com/2020/04/java-8-predicates-and-lambda-expression.html
 *
 *  Predicate é uma interface funcional em Java.
 *  Uma interface funcional nada mais é do que uma função com um método abstrato ou anotada pela @FunctionalInterface.
 *  Predicate é uma interface funcional com uma função que aceita um objeto e retorna Boolean.
     @FunctionalInterface
     Predicate<T> {
     boolean test(T t);
     }

     Exemplo video aula: http://excript.com/java/interface-funcional-predicate-java.html

     Predicate - Não inferido o (TIPO)
     Predicate<String> - inferindo o (TIPO) com isto podemos chamar os method de acordo com o TIPO informado.

 * */
public class PredicateBasic2Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jacky", "Jason", "Barry", "Frank");
        filter(names, s -> s.startsWith("J"));

    }

    public static void filter(List<String> names, Predicate<String> condition) {
        for (String s: names) {
            if (condition.test(s)) {
                System.out.println(s);
            }
        }
    }
}

