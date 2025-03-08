package Introduction.Simple;

import Introduction.domain.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


//1. Order LightNovel by title
//2. Retrieve the first 3 titles light novels with price less than 4
public class SimpleStreams02Test {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));
    public static void main(String[] args) {

        /** Streams operação criacao
         *          operação intermediaria
         *          operação terminais
         * */
        Stream<LightNovel> stream = lightNovels.stream();
        lightNovels.forEach(System.out::println);

        long count = stream
                .distinct() // intermediaria
                .filter(ln -> ln.getPrice() <= 4) // intermediaria
                .count(); // terminal

        System.out.println(count);

        /**
         * Obs: sobre incluimos os equals e hashcode na classe para usamos o distinct na stream
         *
         * */
    }

}
