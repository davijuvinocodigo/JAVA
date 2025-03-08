package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_Quantificadores02 {
    public static void main(String[] args) {

        /**
         * \d = Todos os digitos.
         * \D = Tudo o que não for digito.
         * \s = Espaços em branco.
         * \S = Todos os caracters excluindo os brancos.
         * \w = a-ZA-Z, digitos, _
         * \W = Tudo o que não for incluso no \w
         *  Range []
         *  ? Zero ou uma.
         *  * Zero ou mais.
         *  + uma ou mais.
         *  {n,m} de n até m.
         *  () Agrupamento de valores
         *  | Representa valores concatenados.
         *  $ Representa o fim da linha
         *  .
         */
        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String texto = "expressaoregulares@gmail.com, dfsfsmuito@mail.br";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto : "+texto);
        System.out.println("indice: 0123456789");
        System.out.println("regex " +regex);
        System.out.println("Posicoes encontradas");
        while (matcher.find()){
            System.out.print(matcher.start() + "|" +matcher.group() + "\n");
        }
    }
}
