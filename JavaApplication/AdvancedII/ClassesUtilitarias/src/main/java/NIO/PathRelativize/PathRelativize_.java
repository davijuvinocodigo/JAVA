package NIO.PathRelativize;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *  https://www.geeksforgeeks.org/path-relativize-method-in-java-with-examples/
 */

public class PathRelativize_ {
    public static void main(String[] args) {

        // create objects of Path
        Path path
                = Paths.get("D:\\eclipse\\p2"
                + "\\org\\eclipse");
        Path passedPath
                = Paths.get("D:\\eclipse\\p2"
                + "\\org\\eclipse\\equinox\\p2\\core"
                + "\\cache\\binary");

        // print paths
        System.out.println("This Path:"
                + path);
        System.out.println("Given Path:"
                + passedPath);

        // call relativize() to create
        // a relative path
        Path relativize
                = path.relativize(passedPath);

        // print result
        System.out.println("Relative Path: "
                + relativize);
    }
}
