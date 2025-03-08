package Introduction;

import java.util.*;
import java.util.stream.Collectors;

public class Strems {
    public static void main(String[] args) {

        List<Integer> listaNumeros= Arrays.asList(1, 5, 8, 7, 4, 6, 3, 2, 1, 8, 5, 7, 4);
        listaNumeros.stream().forEach(System.out::print);
        System.out.println();
        System.out.println("*************************************************************");
        System.out.println("Resultado com skip, limit e distinct");

        //Operações intermediárias
        listaNumeros.stream()
                .skip(2) // ignora os dois primeiros números
                .limit(9) // limita a 9 números
                .distinct() // ignora números iguais
                .forEach(System.out::print);

        System.out.println();
        System.out.println("*************************************************************");
        System.out.println("Resultado com filter");
        listaNumeros.stream()
                .filter(e -> e % 2 == 0) // mantém apenas números pares
                .forEach(System.out::print);

        System.out.println();
        System.out.println("*************************************************************");
        System.out.println("Resultado com map");
        listaNumeros.stream()
                .map(e -> e * 2) // multiplica cada item por 2
                .forEach(e -> System.out.print(e + " ")); // imprime todos no console


        System.out.println();
        System.out.println("*************************************************************");
        System.out.println("Operações finais em Streams");
        System.out.println("Resultado com max");
        Optional<Integer> maiorNumero = listaNumeros.stream()
                .map(e -> e * 2) // multiplica cada item por 2
                .max(Comparator.naturalOrder()); // pega o maior item pela ordem natural
        System.out.println(maiorNumero.get());


        System.out.println();
        System.out.println("*************************************************************");
        System.out.println("Resultado com max");
        Optional<Integer> menorNumero = listaNumeros.stream()
                .map(e -> e * 2) // multiplica cada item por 2
                .min(Comparator.naturalOrder()); // pega o menor item pela ordem natural
        System.out.println(menorNumero.get());

        System.out.println();
        System.out.println("*************************************************************");
        System.out.println("Resultado com count");
        Long quantidade = listaNumeros.stream()
                .filter(e -> e % 2 == 0) // mantém apenas números pares
                .count(); // pega quantos itens restam no stream
        System.out.println(quantidade);


        System.out.println();
        System.out.println("*************************************************************");
        System.out.println("Operações com collect");
        System.out.println("Coletar o resultado das operações do Stream");
        List<Integer> novaLista = listaNumeros.stream()
                .filter(e -> e % 2 == 0) // mantém apenas números pares
                .map(e -> e * 2) // multiplica cada item por 2
                .collect(Collectors.toList()); // coleta todos os itens em uma nova lista
        System.out.println(novaLista);


        System.out.println();
        System.out.println("*************************************************************");
        System.out.println("Operações com collect");
        System.out.println("Agrupar os itens da lista em um mapa");
        Map<Boolean, List<Integer>> mapa = listaNumeros.stream()
                .map(e -> e * 2) // multiplica cada item por 2
                .collect(Collectors.groupingBy(e -> e > 8)); // agrupa itens baseado no resultado da comparação
        System.out.println(mapa);



        System.out.println();
        System.out.println("*************************************************************");
        System.out.println("Converting Stream to List in Java");
        List<Integer> listOf100s = listaNumeros.stream()
                .filter(num -> num > 7)
                .collect(Collectors.toList());
        System.out.println("list of numbers convertidas: " + listOf100s);


        System.out.println();
        System.out.println("*************************************************************");
        System.out.println("Converting Stream to ArrayList in Java");
        List<Integer> listOf200s = listaNumeros.stream()
                .filter(num -> num > 7)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("list of numbers convertidas: " + listOf200s);





    }
}
