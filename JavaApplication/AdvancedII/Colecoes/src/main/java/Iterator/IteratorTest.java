package Iterator;


/* PERFORMANCE
    LinkedList<>
    Classe que trabalha com anterior/proximo
* */

import List.domain.Manga;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<Manga> mangas = new LinkedList<>();
        mangas.add(new Manga(2L, "alguma coisa", 19.9, 0));
        mangas.add(new Manga(3L, "alguma coisa2", 14.9, 5));
        mangas.add(new Manga(5L, "alguma coisa3", 1.9, 0));
        mangas.add(new Manga(4L, "alguma coisa4", 15.9, 5));

        //PROGRAMAÇÃO ITERATIVA
        /*Iterator<Manga> iterator = mangas.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getQuantidade() == 0){
                iterator.remove();
            }
        }*/

        //PROGRAMAÇÃO FUNCIONAL
        mangas.removeIf(manga -> manga.getQuantidade() == 0);
        mangas.forEach((e) -> {
            System.out.println(e);
        });
    }
}
