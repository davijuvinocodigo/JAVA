package Optional;

import java.util.Optional;
import java.util.function.Function;

/**
 * https://javabydeveloper.com/java-optional-class-with-examples/
 * */
public class OptionalFlatMapDemo {
    public static void main(String[] args) {

        /*
         * flatMap() - This method is similar to map(Function),
         * but the provided mapper is one whose result is already an Optional, and if invoked,
         * flatMap does not wrap it with an additional Optional.
         * */
        /*----------------------------------------------------------*/
        Optional<Optional> optionalContainer = Optional.of(Optional.of("Peter Milanovich"));
        Optional<Optional> emptyOptionalContainer = Optional.of(Optional.of("Peter Milanovich"));

        Function<String, String> function = s -> s.substring(0, 0).length() == 0 ? null : s;
        Function<String, String> function2 = s -> s.substring(0, 5);

        System.out.println(optionalContainer.map(optional -> optional.map(function2)));//Optional[Optional[Peter]]
        System.out.println(optionalContainer.flatMap(optional -> optional.map(function2)));//Optional[Peter]
        System.out.println(emptyOptionalContainer.flatMap(optional -> optional.map(function)));//Optional.empty


    }
}
