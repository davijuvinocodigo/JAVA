package Optional;


import java.util.Optional;

/**
 * https://www.javatpoint.com/java-8-optional
 * Java introduziu uma nova classe Opcional no jdk8.
 * É uma classe final pública e usada para lidar com NullPointerException no aplicativo Java.
 * Você deve importar o pacote java.util para usar esta classe. Ele fornece métodos que são usados
 * para verificar a presença de valor para determinada variável.
 * */
public class OptionalBasic1Test {
    public static void main(String[] args) {

       /**
        String[] str = new String[10];
        String lowercaseString = str[5].toLowerCase();
        System.out.print(lowercaseString);

        Exception in thread "main" java.lang.NullPointerException
        at Optional.OptionalBasic1Test.main(OptionalBasic1Test.java:7)

        */
        String[] str = new String[10];
        Optional<String> checkNull = Optional.ofNullable(str[5]);
        if(checkNull.isPresent()){  // check for value is present or not
            String lowercaseString = str[5].toLowerCase();
            System.out.print(lowercaseString);
        }else
            System.out.println("string value is not present");
    }

}
