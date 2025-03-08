package HashSet;

/*
* HashSet trabalha com elementos unicos com identificador hash eliminando elementos duplicados
* Por si esta classe não trabalha com index
* A navegação ou iteração pode ser com foreach */

import List.domain.Manga;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<Manga> mangas = new HashSet<>();
        mangas.add(new Manga(2L, "alguma coisa", 19.9, 0));
        mangas.add(new Manga(3L, "alguma coisa2", 14.9, 5));
        mangas.add(new Manga(3L, "alguma coisa2", 14.9, 5));
        mangas.add(new Manga(3L, "alguma coisa2", 14.9, 5));
        mangas.add(new Manga(3L, "alguma coisa2", 14.9, 5));
        mangas.add(new Manga(5L, "alguma coisa3", 1.9, 0));
        mangas.add(new Manga(4L, "alguma coisa4", 15.9, 5));
        for (Manga manga: mangas) {
            System.out.println(manga);
        }

        // Para mantemos a ordem de inserção podemos usar o linkhashset
        Set<Manga> mangas2 = new LinkedHashSet<>();
        mangas2.add(new Manga(2L, "alguma coisa", 19.9, 0));
        mangas2.add(new Manga(3L, "alguma coisa2", 14.9, 5));
        mangas2.add(new Manga(3L, "alguma coisa2", 14.9, 5));
        mangas2.add(new Manga(3L, "alguma coisa2", 14.9, 5));
        mangas2.add(new Manga(3L, "alguma coisa2", 14.9, 5));
        mangas2.add(new Manga(5L, "alguma coisa3", 1.9, 0));
        mangas2.add(new Manga(4L, "alguma coisa4", 15.9, 5));
        System.out.println("MANTENDO A ORDEM COM LINKEDHASHSET");
        for (Manga manga: mangas2) {
            System.out.println(manga);
        }
    }
}
