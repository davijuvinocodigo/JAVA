package FUNCOES.Strings.funcAcentuacao;

import FUNCOES.Strings.funcAcentuacao.domain.Acentuacao;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Run {
    public static String value = "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïñòóôõöøùúûüýþÿatualização LTDA-S.A";
    private static List<Acentuacao> acentuacoes = new ArrayList<>(List.of(
            new Acentuacao(value,1,""),
            new Acentuacao(value,1,""),
            new Acentuacao(value,1,""),
            new Acentuacao(value,1,""),
            new Acentuacao(value,1,""),
            new Acentuacao(value,1,""),
            new Acentuacao(value,1,""),
            new Acentuacao(value,1,"")
    ));

    public static void main(String[] args) throws Exception {
        //System.out.println(semAcento(value));
        //System.out.println(removeAcentos(value));

        List<String> list = acentuacoes.stream()
                .map(e -> removeAcentos(e.getTitulo()))
                .toList();

        list.stream().forEach(System.out::print);
    }

    public static String semAcento(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public static String removeAcentos(String string) {
        if (string != null){
            string = Normalizer.normalize(string, Normalizer.Form.NFD);
            string = string.replaceAll("[^\\p{ASCII}]", "");
        }
        return string;
    }
}
