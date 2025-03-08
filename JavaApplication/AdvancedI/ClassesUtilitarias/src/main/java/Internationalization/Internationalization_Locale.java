package Internationalization;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Internationalization_Locale {
    public static void main(String[] args) {
        // pt-BR

        Locale locale = new Locale("pt", "BR");
        Calendar calendar = Calendar.getInstance();

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);

        System.out.println(df.format(calendar.getTime()));
    }
}
