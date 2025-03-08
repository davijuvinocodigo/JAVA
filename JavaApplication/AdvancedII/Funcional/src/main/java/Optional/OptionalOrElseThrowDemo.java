package Optional;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * https://javabydeveloper.com/java-optional-class-with-examples/
 * */
public class OptionalOrElseThrowDemo {
    public static void main(String[] args) {

        Optional<String> nonEmptyOptional = Optional.of("Peter Milanovich");
        Optional<String> emptyOptional = Optional.empty();

        // orElseThrow() - Return the contained value, if present, otherwise
        //throw an exception to be created by the provided supplier.
        /*----------------------------------------------------------*/
        System.out.println(nonEmptyOptional.orElseThrow(NullPointerException::new));//Peter Milanovich
        System.out.println(emptyOptional.orElseThrow(NullPointerException::new));//NullPointerException

    }
}
