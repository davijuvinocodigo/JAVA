package Reference.Instance;


import java.util.function.Function;

/**
 * Referência de método de instância não vinculada
 * Um receptor não vinculado usa a seguinte sintaxe
 *
 * ClassName::instanceMethod
 *
 * É a mesma sintaxe que usamos para referenciar um método estático.
 *
 * No código a seguir, podemos ver que o tipo de entrada é do tipo ClassName.
 *
 * No código a seguir, usamos String:length então o tipo de entrada da interface funcional é String.
 *
 * A expressão lambda obtém a entrada quando está sendo usada.
 *
 * O código a seguir usa o método String length como referência de método de instância unbind.
 *
 * O método String length geralmente é chamado em uma instância de valor de string e retorna
 * o comprimento da instância de string. Portanto, a entrada é do tipo String e a saída é do tipo
 * int, que corresponde à Function interface funcional buildin.
 *
 * Cada vez que chamamos, strLengthFunc passamos um valor de string e o método length é chamado
 * a partir do valor de string passado.
 *
 * */
public class ReferenceInstanceUnboundTest {
    public static void main(String[] argv){
        Function<String,  Integer> strLengthFunc = String::length;
        String name ="java2s.com";
        int len   =  strLengthFunc.apply(name);
        System.out.println("name  = "  +  name + ", length = "  + len);

        name ="www.java2s.com";
        len   =  strLengthFunc.apply(name);
        System.out.println("name  = "  +  name + ", length = "  + len);

    }
}
