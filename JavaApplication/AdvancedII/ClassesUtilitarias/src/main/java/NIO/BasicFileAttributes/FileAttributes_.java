package NIO.BasicFileAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttributes_ {
    public static void main(String[] args) {
        // path of the file
        String path = "pasta/arquivo.txt";

        // creating a object of Path class
        Path file = Paths.get(path);

        // creating a object of BasicFileAttributes
        BasicFileAttributes attr = null;
        try {
            attr = Files.readAttributes(
                    file, BasicFileAttributes.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("creationTime Of File Is  = "
                + attr.creationTime());
        System.out.println("lastAccessTime Of File Is  = "
                + attr.lastAccessTime());
        System.out.println("lastModifiedTime Of File Is = "
                + attr.lastModifiedTime());

        System.out.println("size Of File Is = "
                + attr.size());
        System.out.println("isRegularFile Of File Is = "
                + attr.isRegularFile());
        System.out.println("isDirectory Of File Is = "
                + attr.isDirectory());
        System.out.println("isOther Of File Is = "
                + attr.isOther());

        System.out.println("isSymbolicLink Of File Is  = "
                + attr.isSymbolicLink());
    }
}
