package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A ordem de inserção não é retida no PriorityQueue. Os elementos são armazenados com base na ordem de prioridade que é crescente por padrão.
 * */
public class QueueTest {
    public static void main(String[] args) {

        Queue<String> fila1 = new LinkedList<>();
        fila1.add("C");
        fila1.add("A");
        fila1.add("B");

        System.out.println("remove the element at the front of the queue");
        while(!fila1.isEmpty()){
            String front = fila1.remove();
            System.out.println("Removed element: " + front);
        }

    }
}
