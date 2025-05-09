package NavigableSet;

import List.domain.Manga;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class MangaPrecoComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}

public class NavigableSetTestMethods {
    public static void main(String[] args) {

        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());
        mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9,0));
        mangas.add(new Manga(1L, "Berserk", 9.5,5));
        mangas.add(new Manga(4L, "Pokemon", 3.2,0));
        mangas.add(new Manga(3L, "Attack on titan", 11.20,2));
        mangas.add(new Manga(2L, "Dragon ball Z", 2.99,0));
        mangas.add(new Manga(10L, "Aaragon", 2.99,0));
        mangas.add(new Manga(10L, "Aaragon", 10.0,0));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        Manga yuyu = new Manga(21L, "Yuyu Hakusho", 3.2, 5);
        // lower <
        // floor <=
        // higher >
        // ceiling >=
        System.out.println("------------");
        System.out.println(mangas.lower(yuyu));
        System.out.println(mangas.floor(yuyu));
        System.out.println(mangas.higher(yuyu));
        System.out.println(mangas.ceiling(yuyu));

        System.out.println(mangas.size());
        System.out.println(mangas.pollLast());
        System.out.println(mangas.size());

    }
}
