package Optional;

import java.util.Optional;

/**
 * https://javabydeveloper.com/java-optional-class-with-examples/
 * */
public class OptionalIsPresentDemo {
    public static void main(String[] args) {

        //isPresent() - returns true if value Present otherwise false
        /*----------------------------------------------------------*/
        Optional nonEmptyOptional = Optional.of("Peter Milanovich");
        Optional emptyOptional = Optional.empty();

        System.out.println(emptyOptional.isPresent());//false
        System.out.println(nonEmptyOptional.isPresent());//true
    }
}
