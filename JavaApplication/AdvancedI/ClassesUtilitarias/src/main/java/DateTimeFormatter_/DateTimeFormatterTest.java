package DateTimeFormatter_;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {
    public static void main(String[] args) {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
    }
}
