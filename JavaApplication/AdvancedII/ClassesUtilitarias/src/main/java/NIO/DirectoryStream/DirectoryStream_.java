package NIO.DirectoryStream;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStream_ {
    public static void main(String[] args) {
        try {
            Path path = Paths.get(".");
            try (DirectoryStream<Path> streams = Files.newDirectoryStream(path)) {
                streams.forEach(e -> System.out.println(e.getFileName()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
