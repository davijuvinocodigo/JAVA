package IO.FileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Trabalhando com Try resource para fechar um recurso automaticamento.
 */

public class FileWriter_ {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try(FileWriter fw = new FileWriter(file)) {
            fw.write("trabalhando com write..");
            fw.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
