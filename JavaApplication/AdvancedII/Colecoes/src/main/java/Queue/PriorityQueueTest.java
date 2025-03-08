package Queue;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/priority-queue-class-in-java/
 * https://www.geeksforgeeks.org/queue-interface-java/
 *
 * Um PriorityQueue é usado quando os objetos devem ser processados com base na prioridade.
 * Sabe-se que uma Queue segue o algoritmo First-In-First-Out, mas às vezes os elementos da fila precisam ser processados
 * acordo com a prioridade, é aí que o PriorityQueue entra em ação.
 *
 * O PriorityQueue é baseado no heap de prioridade. Os elementos da fila de prioridade são ordenados de acordo com a ordem natural,
 * ou por um Comparator fornecido no momento da construção da fila,
 * dependendo de qual construtor é utilizado.
 *
 * */
public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<String> pq = new PriorityQueue<>();
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");
        System.out.println(pq);
        System.out.println("#########################################################################");
        System.out.println();

        /**
         * Removendo Elementos: Para remover um elemento de uma fila, podemos usar o método remove().
         * Se houver vários desses objetos, a primeira ocorrência do objeto será removida.
         * Além disso, o método poll() também é usado para remover a cabeça e retorná-la.
         * */
        System.out.println("Removendo Elementos:");
        Queue<String> we = new PriorityQueue<>();
        we.add("Geeks");
        we.add("For");
        we.add("Geeks");
        System.out.println("Initial Queue " + we);

        we.remove("Geeks");

        System.out.println("After Remove " + we);
        System.out.println("Poll Method " + we.poll());
        System.out.println("Final Queue " + we);
        System.out.println("#########################################################################");
        System.out.println();

        /**
         * Iterando a Fila: Existem várias maneiras de iterar na Fila.
         * A maneira mais famosa é converter a fila em array e percorrê-la usando o loop for.
         * No entanto, a fila também possui um iterador embutido que pode ser usado para iterar na fila.
         * */
        System.out.println("Iterando a Fila:");
        Queue<String> tr = new PriorityQueue<>();
        tr.add("Geeks");
        tr.add("For");
        tr.add("Geeks");

        Iterator iterator = tr.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
