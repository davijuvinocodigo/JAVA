package ChronoUnit_new;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChronoUnit_ {
    public static void main(String[] args) {
        System.out.println(ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.of(1970, 1, 1)));
    }

}
