package NIO.PathNormalizacao;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathNormalizacao_ {
    public static void main(String[] args) {
        // create object of Path
        // In this example \\.. starts with non".."
        // element
        Path path
                = Paths.get("D:\\..\\..\\.\\p2\\core"
                + "\\cache\\binary");

        // print actual path
        System.out.println("Actual Path : "
                + path);

        // normalize the path
        Path normalizedPath = path.normalize();

        // print normalized path
        System.out.println("\nNormalized Path : "
                + normalizedPath);

    }
}
