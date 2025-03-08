package Consume;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Uma interface Consumer  é uma interface funcional predefinida que pode ser usada ao criar expressões
 * lambda  ou referências de método  . Essa interface representa uma operação que aceita um único parâmetro de entrada
 * e não retorna nada. Ele contém apenas um método chamado accept() .
 *
 * A interface BiConsumer  é semelhante a uma interface Consumer e aceita dois parâmetros de entrada
 * e não retorna nada.
 *
 * https://mkyong.com/java8/java-8-consumer-examples/
 * */
public class ConsumeBasic2Test {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // implementation of the Consumer's accept methods.
        Consumer<Integer> consumer = (Integer x) -> System.out.println(x);
        forEach(list, consumer);

        // or call this directly
        forEach(list, (Integer x) -> System.out.println(x));

    }

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
