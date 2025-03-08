package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch_ {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);
        // (-(ponto de inserção) -1)
        // index 0,1,2,3
        // value 0,2,3,4
        Collections.sort(numeros);
        System.out.println("PROX POSICAO DO ELEMENT POSITIVA: " + Collections.binarySearch(numeros,0));
        System.out.println("INDICADOR NEGATIVA DA POSICAO: " + Collections.binarySearch(numeros,67) + " QUE NAO EXISTE VALOR INFORMADO");
    }
}
