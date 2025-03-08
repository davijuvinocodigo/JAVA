package List;

import List.domain.Smartphone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class List_ {
    public static void main(String[] args) {
        /**
         *  1.4 - Até esta version não era passado um tipo
          */
        List nome = new ArrayList();


        /**
         * 1.5 - A partir desta version estamos definindo um tipo
         */
        List<String> nomes = new ArrayList<>(Arrays.asList("dado1", "dados2", "dados3"));
        for (int i = 0; i < nomes.size(); i++){
            System.out.println(nomes.get(i));
        }


        /**
         * Adicionando valores a outras lista
         */
        System.out.println();
        System.out.println("Adicionando valores a outras lista");
        List<String> nomes2 = new ArrayList<>(Arrays.asList("outro1", "outro2"));
        nomes.addAll(nomes2);
        for (String n: nomes) {
            System.out.println(n);
        }


        /**
         * Trabalhando com objetos
         */
        System.out.println();
        System.out.println("List Objetos");
        Smartphone s1 = new Smartphone("1ABC2", "IPhone");
        Smartphone s2 = new Smartphone("22222", "Pixel");
        Smartphone s3 = new Smartphone("33333", "Samsung");

        List<Smartphone>  smartphones = new ArrayList<>();
        smartphones.add(s1);
        smartphones.add(s2);
        smartphones.add(s3);

        for (Smartphone s : smartphones){
            System.out.println(s);
        }


        /**
         * Comparando objetos
         * Neste caso o java verificar se existe o objeto com os seguintes valores (O Metodos de comparação é o equals que foi sobrescrito)
         * Por padrao o java vai usar o metodo equals do objeto para esta comparação
         * Aqui o resultado será (TRUE)
         */
        System.out.println();
        Smartphone s4 = new Smartphone("1ABC2", "IPhone");
        System.out.println(smartphones.contains(s4));


    }
}
