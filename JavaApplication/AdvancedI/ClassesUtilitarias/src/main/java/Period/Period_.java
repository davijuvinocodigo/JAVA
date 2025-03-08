package Period;

import java.time.LocalDate;
import java.time.Period;

public class Period_ {
    public static void main(String[] args) {
        Period between = Period.between(LocalDate.now(), LocalDate.now().plusYears(2));
        System.out.println(between);
    }
}
