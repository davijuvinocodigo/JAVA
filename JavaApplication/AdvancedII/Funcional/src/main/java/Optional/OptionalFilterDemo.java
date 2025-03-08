package Optional;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * https://javabydeveloper.com/java-optional-class-with-examples/
 * */
public class OptionalFilterDemo {
    public static void main(String[] args) {

        Optional<String> nonEmptyOptional = Optional.of("Peter Milanovich");
        Optional<String> emptyOptional = Optional.empty();

        /* filter() - If a value is present, and value matches the given predicate,
         return an Optional otherwise return an empty Optional. */
        /*----------------------------------------------------------*/
        Predicate<String> predicate = s -> s.contains("Milanovich");
        System.out.println(nonEmptyOptional.filter(predicate));//Optional[Peter Milanovich]
        System.out.println(nonEmptyOptional.filter(s -> s.equals("Peter")));//Optional.empty
        System.out.println(emptyOptional.filter(predicate));//Optional.empty
        System.out.println(nonEmptyOptional.filter(s -> s.startsWith("P")));//Optional[Peter Milanovich]

    }
}
