package List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {

        /**
         * Ordernação de valores
         */
        List<String> list = new ArrayList<>();
        list.add("AAAA");
        list.add("DDDD");
        list.add("CCCC");
        list.add("BBBB");
        list.add("FFFF");

        Collections.sort(list);
        System.out.println(list);
    }
}
