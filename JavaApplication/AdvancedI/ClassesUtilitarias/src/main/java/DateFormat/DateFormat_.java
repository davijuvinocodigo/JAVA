package DateFormat;

import java.text.DateFormat;
import java.util.Calendar;

/**
 *  Trabalhando com formatação de datas
 */
public class DateFormat_ {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        DateFormat df =  DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println(df.format(calendar.getTime()));

    }
}
