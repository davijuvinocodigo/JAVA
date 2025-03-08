package Optional;

import java.util.Optional;
import java.util.function.Function;

/**
 * https://javabydeveloper.com/java-optional-class-with-examples/
 * */
public class OptionalOrElseDemo {
    public static void main(String[] args) {

        Optional<String> nonEmptyOptional = Optional.of("Peter Milanovich");
        Optional<String> emptyOptional = Optional.empty();

        // orElse() - Return the value if present, otherwise return other.
        /*----------------------------------------------------------*/
        System.out.println(nonEmptyOptional.orElse("Gerhard Gogoush"));//Peter Milanovich
        System.out.println(emptyOptional.orElse("Gerhard Gogoush"));//Gerhard Gogoush


    }
}
