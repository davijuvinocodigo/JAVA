package Methods;

import java.util.List;

/**
 * https://www.programiz.com/java-programming/generics
 * */

public class GenericsMethodTest {
    public static void main(String[] args) {

        // initialize the class with Integer data
        DemoClass demo = new DemoClass();

        // generics method working with String
        demo.<String>genericsMethod("Java Programming");

        // generics method working with integer
        demo.<Integer>genericsMethod(25);

        List<String> string = demo.createArrayObject(new String("AAAAAA"));

        List<Integer> number = demo.createArrayObject(Integer.valueOf(1));

    }
}

class DemoClass {

    // creae a generics method
    public <T> void genericsMethod(T data) {
        System.out.println("Generics Method:");
        System.out.println("Data Passed: " + data);
    }

    // create a generics method list
    public <T> List<T> createArrayObject(T t){
        return List.of(t);
    }
}
