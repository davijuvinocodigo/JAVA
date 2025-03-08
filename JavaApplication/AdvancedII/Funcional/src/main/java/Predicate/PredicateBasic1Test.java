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
 * */
public class PredicateBasic1Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jacky", "Jason", "Barry", "Frank");

        System.out.println("Display All names : ");
        process(names, c -> true);

        System.out.println("Display No names : ");
        process(names, c -> false);


        Predicate<String> i  = (s)-> s.length() > 5;
        System.out.println("Display length > string : " + i.test("java2s.com "));

    }

    public static void process(Collection names, Predicate condition) {
        for (Object name: names) {
            if (condition.test(name)) {
                System.out.printf("%s, ", name);
            }
        }
    }
}

