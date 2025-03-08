package NIO.Path02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Trabalhando com subDiretorys
 */

public class Path_02 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta");
        if (Files.notExists(path)){
            Path diretory = Files.createDirectories(path);
        }

        Path subPastaPath = Paths.get("pasta/subpasta/subsubpasta");
        Path subPastaDiretory = Files.createDirectories(subPastaPath);
    }
}
