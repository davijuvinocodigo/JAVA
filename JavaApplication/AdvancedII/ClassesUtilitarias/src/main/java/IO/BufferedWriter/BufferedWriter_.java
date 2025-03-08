package IO.BufferedWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Trabalhando com a memoria do bufferedWrite
 */

public class BufferedWriter_ {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try(FileWriter fw = new FileWriter(file)) {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("trabalhando com buffered write..");
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
