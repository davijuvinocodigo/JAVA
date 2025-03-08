package NIO.DosFileAttribute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

/**
 * https://www.tabnine.com/code/java/classes/java.nio.file.attribute.DosFileAttributes
 */

public class DosFileAttribute_ {
    public static void main(String[] args) {
        Path srcFile = Paths.get("pasta/arquivo.txt");
        DosFileAttributes dfa = null;
        try {
            dfa = Files.readAttributes(srcFile, DosFileAttributes.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("System File? " + dfa.isSystem());
        System.out.println("Hidden File? " + dfa.isHidden());
    }
}
