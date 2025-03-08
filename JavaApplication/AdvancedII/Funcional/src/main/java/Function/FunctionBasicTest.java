package Function;

import java.util.function.Function;

/**
 * Function representa uma função que aceita um argumento e produz um resultado.
 * http://www.java2s.com/Tutorials/Java/java.util.function/Function/index.htm
 * https://ashishtechmill.com/java-functional-interfaces-for-the-impatient-part-1
 * https://o7planning.org/13497/java-function
 * Function apply
 * Function compose
 * Function andThen
 * Function identity
 * */
public class FunctionBasicTest {
    public static void main(String[] args) {
        Function<Integer,String> converter = (i)-> Integer.toString(i);

        System.out.println(converter.apply(3).length());
        System.out.println(converter.apply(30).length());
    }
}
