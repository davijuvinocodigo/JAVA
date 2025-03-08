package Internationalization;

import java.text.NumberFormat;
import java.util.Locale;

public class Internationalization_Moeda {
    public static void main(String[] args) {

        Locale locale = new Locale("pt", "BR");
        NumberFormat nf = NumberFormat.getInstance(locale);
        nf.getMaximumFractionDigits();
        double num = 10_000.2130;

        System.out.println(nf.format(num));
    }
}
