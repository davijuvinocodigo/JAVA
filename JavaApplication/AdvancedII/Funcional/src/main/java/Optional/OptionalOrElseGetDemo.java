package Optional;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * https://javabydeveloper.com/java-optional-class-with-examples/
 * */
public class OptionalOrElseGetDemo {
    public static void main(String[] args) {

        Optional<String> nonEmptyOptional = Optional.of("Peter Milanovich");
        Optional<String> emptyOptional = Optional.empty();

        /* orElseGet - Return the value if present, otherwise invoke other
        and return the result of that invocation.*/
        /*----------------------------------------------------------*/
        Supplier<String> supplier = () -> "Gerhard Gogoush";

        System.out.println(nonEmptyOptional.orElseGet(supplier));//Peter Milanovich
        System.out.println(emptyOptional.orElseGet(supplier));//Gerhard Gogoush

    }
}
