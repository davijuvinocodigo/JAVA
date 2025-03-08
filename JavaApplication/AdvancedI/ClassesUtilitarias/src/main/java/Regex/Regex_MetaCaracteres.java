package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://regexr.com
 */

public class Regex_MetaCaracteres {
    public static void main(String[] args) {

        /**
         * \d = Todos os digitos.
         * \D = Tudo o que não for digito.
         * \s = Espaços em branco.
         * \S = Todos os caracters excluindo os brancos.
         * \w = a-ZA-Z, digitos, _
         * \W = Tudo o que não for incluso no \w
         */
        String regex = "\\d";
        String texto = "ababa656ass78ss";
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
