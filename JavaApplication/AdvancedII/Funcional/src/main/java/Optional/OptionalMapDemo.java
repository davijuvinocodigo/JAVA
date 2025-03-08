package Optional;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * https://javabydeveloper.com/java-optional-class-with-examples/
 * */
public class OptionalMapDemo {
    public static void main(String[] args) {

        Optional<String> nonEmptyOptional = Optional.of("Peter Milanovich");
        Optional<String> emptyOptional = Optional.empty();
        /*
         * map() - If a value is present, apply the provided mapping function to it, and
         * if the result is non-null, return an Optional describing the result.
         * Otherwise return an empty Optional.
         */
        /*----------------------------------------------------------*/
        Function<String, String> function = s -> s.substring(0, 0).length() == 0 ? null : s;

        System.out.println(nonEmptyOptional.map(function));// Optional.empty
        System.out.println(nonEmptyOptional.map(String::toLowerCase));// Optional[peter milanovich]
        System.out.println(emptyOptional.map(function));// Optional.empty

    }
}
