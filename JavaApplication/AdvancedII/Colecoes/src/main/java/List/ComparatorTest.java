package List;

import List.domain.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Uma interface de Comparator é usada para ordenar os objetos de classes definidas pelo usuário.
 * Um objeto Comparator é capaz de comparar dois objetos da mesma classe .
 */

class SortingByIdComparator implements Comparator<Manga> {


    @Override
    public int compare(Manga o1, Manga o2) {
        return o1.getId().compareTo(o2.getId());
    }
}


public class ComparatorTest {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(2L, "alguma coisa", 19.9));
        mangas.add(new Manga(3L, "alguma coisa2", 14.9));
        mangas.add(new Manga(5L, "alguma coisa3", 1.9));
        mangas.add(new Manga(4L, "alguma coisa4", 15.9));

        Collections.sort(mangas, new SortingByIdComparator());

        for (Manga m : mangas) {
            System.out.println(m);
        }
    }
}


