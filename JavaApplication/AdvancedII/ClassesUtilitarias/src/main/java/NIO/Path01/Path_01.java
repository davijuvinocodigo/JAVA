package NIO.Path01;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Novo pacote com novos recursos
 */

public class Path_01 {
    public static void main(String[] args) {
        Path path = Paths.get("C" ,"Users", "davi",
                "Documents",
                "Developments",
                "backend",
                "JavaApplication",
                "AdvancedII",
                "ClassesUtilitarias",
                "file.txt");
        System.out.println(path.getFileName());
    }
}
