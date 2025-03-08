package FlatMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SimpleFlatMap01Test {
    public static void main(String[] args) {
        List<List<String>> devdojo = new ArrayList<>();
        List<String> graphicDesigners = List.of("Wildnei Suane", "Catarina Santos", "Sandy Carolina");
        List<String> developers = List.of("William", "David", "Harisson");
        List<String> students = List.of("Édipo", "Gustavo Lima", "Gustavo Mendes", "Guilherme");
        devdojo.add(graphicDesigners);
        devdojo.add(developers);
        devdojo.add(students);

        // Interando nos objetos
        // Primeiro nivel objetos: graphicDesigners, developers, students
        // Segundo nivel conteudo: david.. gustavo...edipo..
        for (List<String> people : devdojo) {
            for (String person : people) {
                System.out.println(person);
            }
        }
        System.out.println("----");
        System.out.println("Usando Sream");
        devdojo.stream()
                .flatMap(Collection::stream) // Retornando uma coleção com metodos de referencias
                .forEach(System.out::println); // Retornando uma operação terminal com metodos de referencias


        /**
         * O MAP trabanha no primeiro nivel exemplo: stream().map()
         * */
    }
}
