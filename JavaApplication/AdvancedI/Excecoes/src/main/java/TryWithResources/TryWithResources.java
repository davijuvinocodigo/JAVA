package TryWithResources;

import java.io.*;
import java.util.Scanner;

/**
 * A instrução try -with-resources é uma instrução try que declara um ou mais recursos.
 * Um recurso é um objeto que deve ser fechado depois que o programa terminar com ele.
 * A instrução try -with-resources garante que cada recurso seja fechado no final da instrução.
 */

public class TryWithResources {
    public static void main(String[] args) {

    }

    public static void lerArquivoInvalido(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void lerArquivoValido(){
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
