package Reference.Constructor;

import java.util.Arrays;
import java.util.function.IntFunction;

/**
 * Referências do Construtor de Matriz
 * Podemos criar uma matriz usando o construtor de matriz da seguinte maneira.
 *
 * ArrayTypeName::new
 *
 * int[]::newestá ligando new int[]. new int[]requer um intvalor de tipo como o
 * comprimento da matriz, portanto, int[]::newprecisa de um intvalor de entrada de tipo.
 *
 * O código a seguir usa a referência do construtor de matriz para criar uma matriz int.
 *
 * */
public class ConstructorReferenceArrayBasicTest {
    public static void main(String[] argv){

        IntFunction<int[]> arrayCreator1 = size ->  new int[size];
        // Creates an  int array of  five  elements
        int[] intArray1  = arrayCreator1.apply(5);
        System.out.println(Arrays.toString(intArray1));

        IntFunction<int[]> arrayCreator2 = int[]::new;
        int[] intArray2 = arrayCreator2.apply(5);
        System.out.println(Arrays.toString(intArray2));
    }
}
