package Reference.Static;

/**
 * http://www.java2s.com/Tutorials/Java/java.util.function/Predicate/index.htm
 * Uma expressão lambda representa uma função anônima definida em uma interface funcional.
 * Uma referência de método cria uma expressão lambda usando um método existente.
 *
 * The general syntax for a method reference is
 *
 * Qualifier::MethodName
 * Dois pontos consecutivos atuam como um separador.
 *
 * O MethodName é o nome do método.
 *
 * Qualifier informa onde encontrar a referência do método.
 * */

/**
 * Exemplo
 * Por exemplo, podemos usar String::length para referenciar o método length da String classe.
 * Aqui String está o qualificador e length é o nome do método.
 *
 * Precisamos apenas especificar o nome do método.
 *
 * Não há necessidade de especificar os tipos de parâmetro e tipo de retorno para o método.
 *
 * O tipo de destino da referência de método é uma interface funcional.
 * Ele determina a assinatura do método e resolve o método sobrecarregado, se necessário.
 * */

import java.util.function.Function;

/**
 * Tipos de Referências de Método
 * Existem seis tipos de referência de método.
 *
 * TypeName::staticMethod - referência a um método estático de uma classe, uma interface ou um enum
 * objectRef::instanceMethod - referência a um método de instância
 * ClassName::instanceMethod - referência a um método de instância de uma classe
 * TypeName.super::instanceMethod - referência a um método de instância do supertipo de um objeto
 * ClassName::new - referência ao construtor de uma classe
 * ArrayTypeName::new - referência ao construtor do tipo de array especificado
 *
 * */
public class StaticBasic1Test {
    public static void main(String[] argv) {

        /**
         * Referências de métodos estáticos
         * Uma referência de método estático nos permite usar um método estático como uma expressão lambda.
         *
         * Os métodos estáticos podem ser definidos em uma classe, uma interface ou uma enumeração.
         *
         * O código a seguir define duas expressões lambda.
         *
         * A primeira expressão lambda func1  é criada definindo um parâmetro de entrada x
         * e fornecendo o corpo da expressão lambda. Basicamente, é a maneira normal de criar uma expressão lambda.
         *
         * A segunda expressão lambda func2  é criada referenciando um método estático da Integerclasse.
         *
         * */

        // Using  a  lambda  expression
        Function<Integer, String> func1 = x -> Integer.toBinaryString(x);
        System.out.println(func1.apply(10));

        // Using  a  method  reference
        Function<Integer, String> func2 = Integer::toBinaryString;
        System.out.println(func2.apply(10));
    }
}