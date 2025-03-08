package Reference.Instance;


/**
 *  referência de método de instância Java
 *
 * Podemos obter uma referência de método de instância de duas maneiras, da instância do objeto ou do nome da classe.
 *
 * Basicamente, temos as duas formas a seguir.
 *
 * instância::MethodName
 * ClassName::MethodName
 * Aqui o instancerepresenta qualquer instância de objeto. ClassNameé o nome da classe, como String, Integer.
 *
 * instancee ClassNamesão chamados de receptor. Mais especificamente, instanceé chamado de receptor limitado enquanto ClassNameé chamado de receptor ilimitado.
 *
 * Chamamos instancereceptor limitado, pois o receptor é limitado à instância.
 *
 * ClassNameé um receptor não vinculado, pois o receptor é limitado posteriormente.
 *
 * */

import java.util.function.Supplier;

/**
 *  Referência de método de instância vinculada
 *
 * O receptor Bound Receiver tem a seguinte forma:
 *
 * instance::MethodName
 *
 * No código a seguir, usamos a interface funcional do sistema build in Supplier como o tipo de expressão lambda.
 *
 * Inicialmente, definimos uma expressão lambda de maneira normal. A expressão lambda não aceita nenhum parâmetro
 * e retorna o comprimento de uma string 'java2s.com'
 *
 * Em seguida, criamos uma instância de String com 'java2s.com' e usamos seu método de comprimento como referência
 * do método de instância.
 *
 * Bound significa que já especificamos a instância.
 *
 * O exemplo a seguir mostra como usar o receptor vinculado e o método sem parâmetros para criar referências de método
 * de instância.
 *
 * */
public class ReferenceInstanceBasic1Test {
    public static void main(String[] argv){

        Supplier<Integer> supplier  = () ->  "java2s.com".length();
        System.out.println(supplier.get());

        Supplier<Integer> supplier1  = "java2s.com"::length;
        System.out.println(supplier1.get());
    }
}
