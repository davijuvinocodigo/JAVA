package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://regexr.com
 */

public class Regex_Match {
    public static void main(String[] args) {
        String regex = "aba";
        String texto = "abababassss";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto : "+texto);
        System.out.println("indice: 0123456789");
        System.out.println("regex " +regex);
        System.out.println("Posicoes encontradas");
        while (matcher.find()){
            System.out.print(matcher.start() + "|");
        }
    }
}
