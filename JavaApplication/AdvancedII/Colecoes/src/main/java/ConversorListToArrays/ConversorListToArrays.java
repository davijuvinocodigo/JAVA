package ConversorListToArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversorListToArrays {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        System.out.println("--CONVERSÃO COM PERFORMANCE COM INSTANCIA INDICADOR ZERO(UTILIZACAO DO REFLECTION)");
        Integer[] listToArray = numeros.toArray(new Integer[0]);
        System.out.println(Arrays.toString(listToArray));
        System.out.println("-------------");

        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;
        System.out.println("--CONVERSÃO NÃO INDICADA, MOTIVO RESULTADO LINKADO COM ANTERIOR-");
        List<Integer> arrayToList = Arrays.asList(numerosArray);
        arrayToList.set(0,12);
        System.out.println(Arrays.toString(numerosArray));
        System.out.println(arrayToList);

        System.out.println("--CONVERSÃO CORRETA-");
        List<Integer> numerosList = new ArrayList<>(Arrays.asList(numerosArray));
        numerosList.add(15);
        System.out.println(numerosList);

        List<String> strings = Arrays.asList("1", "2");
    }
}
