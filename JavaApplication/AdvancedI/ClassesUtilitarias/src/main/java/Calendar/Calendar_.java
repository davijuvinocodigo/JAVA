package Calendar;


import java.util.Calendar;

/**
 *      Classe abstrata
 */

public class Calendar_ {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
    }
}
