package Introduction.Simple;

import Introduction.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


//1. Order LightNovel by title
//2. Retrieve the first 3 titles light novels with price less than 4
public class SimpleSemStream01Test {
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

        // Passo - 1 ordenação
        lightNovels.sort(Comparator.comparing(LightNovel::getTitle));
        List<String> titles = new ArrayList<>();
        
        // Inicializando a list of titles        
        for (LightNovel lightNovel : lightNovels) {
            if(lightNovel.getPrice() <=4){  // Passo - 2 filtro de valores
                titles.add(lightNovel.getTitle());  // Passo - 4 obter os valores de titulos
            }
            if(titles.size() >=3){ // Passo - 3 limitador
                break;
            }
        }

        System.out.println(lightNovels);
        System.out.println(titles);
    }

}
