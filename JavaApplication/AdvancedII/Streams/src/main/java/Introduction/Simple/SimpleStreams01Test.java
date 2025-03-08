package Introduction.Simple;

import Introduction.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


//1. Order LightNovel by title
//2. Retrieve the first 3 titles light novels with price less than 4
public class SimpleStreams01Test {
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

        /** Streams operação sequencial
         *          operação intermediaria
         *          operação final
         * */
        List<String> titles = lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle)) // passo 1 operação intermediaria
                .filter(ln -> ln.getPrice() <= 4) // passo 2 operação intermediaria
                .limit(3) // passo 3 operação intermediaria
                .map(LightNovel::getTitle) // passo 4 operação intermediaria
                .collect(Collectors.toList()); // Operação final de retorno

        System.out.println(titles);

        /**
         * lightNovels.stream().forEach vs lightNovels.forEach
         *
         * Com relação a performance devemos usar o method que já existe no retorno da listde para não desperdiçarmos processamento.
         * */
    }

}
