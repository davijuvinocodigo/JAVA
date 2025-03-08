package FlatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleFlatMap02Test {
    public static void main(String[] args) {
        List<String> words = List.of("Gomu", "Gomu", "No", "Mi");

        System.out.println("Retornando todas as letras separadas");
        String[] letters = words.get(0).split("");
        System.out.println(Arrays.toString(letters));
        System.out.println();


        List<String[]> collect = words.stream().map(w -> w.split("")).collect(Collectors.toList());
        Stream<String> stream = Arrays.stream(letters);


        List<String> letters2 = words.stream()
                .map(w -> w.split("")) //Stream<String[]>
                .flatMap(Arrays::stream) // resultado: Stream<String> // aqui eu extraio os dados de dentro do arrays no caso do Stream<String[]>
                .collect(Collectors.toList());
        System.out.println(letters2);

        /**
         * O MAP trabanha no primeiro nivel exemplo: stream().map()
         * */
    }
}
