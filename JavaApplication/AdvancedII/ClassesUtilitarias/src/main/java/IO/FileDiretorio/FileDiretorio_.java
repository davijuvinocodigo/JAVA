package IO.FileDiretorio;

import java.io.File;
import java.io.IOException;

public class FileDiretorio_ {
    public static void main(String[] args) {
        File fl = new File("pasta");
        fl.mkdir();
        File fileNewArquivo = new File(fl, "arquivo.txt");
        try {
            fileNewArquivo.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
