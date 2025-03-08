package Introduction.OpeCriacao;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * A API Streams foi desenvolvida sob o pacote java.util.stream.
 * A forma mais comum de criar uma stream é através de uma coleção de dados,
 * tendo em vista que o principal propósito dessa API é tornar mais flexível
 * e eficiente o processamento de coleções.
 * https://ajuda.gitlab.io/guia-rapido/java/linguagem/stream
 * */
public class CriacaoManipulacao {
    public static void main(String[] args) throws IOException {

        /*
         * Stream de uma coleção
         */
        List<String> lista = new ArrayList<String>();
        lista.addAll(Arrays.asList("A", "B", "C"));

        Stream<String> streamLista = lista.stream();


        /*
         * Stream de um map
         */
        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(0, "A");
        map.put(1, "B");
        map.put(2, "C");

        Stream<String> streamMap = map.values().stream();


        /*
         * Stream de valores, arrays e I/O
         */
        Stream<Integer> valores = Stream.of(1, 2, 3, 4, 5);

        IntStream array = Arrays.stream(new int[] {1, 2, 3, 4, 5});

        Stream <String> io = Files.lines(Paths.get("Exemplo.java"), Charset.defaultCharset());
    }
}

