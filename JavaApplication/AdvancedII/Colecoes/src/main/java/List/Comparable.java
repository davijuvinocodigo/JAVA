package List;

import List.domain.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Comparable incluindo o metodo que faz ordernação por index, assim o java vai realizar a chamada de forma dinamica
 * na inicialização do objeto.
 */

public class Comparable {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(2L, "alguma coisa", 19.9));
        mangas.add(new Manga(3L, "alguma coisa2", 14.9));
        mangas.add(new Manga(5L, "alguma coisa3", 1.9));
        mangas.add(new Manga(4L, "alguma coisa4", 15.9));
        Collections.sort(mangas);
        for (Manga m : mangas) {
            System.out.println(m);
        }
    }
}
