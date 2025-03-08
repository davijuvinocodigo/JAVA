package NIO.PathResolve;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * https://www.geeksforgeeks.org/path-resolve-method-in-java-with-examples/
 */
public class PathResolve_ {
    public static void main(String[] args) {
        // create an object of Path
        Path path
                = Paths.get("drive\\temp\\Spring");

        // create a string object
        String passedPath = "drive";

        // call resolve() to create resolved Path
        Path resolvedPath
                = path.resolve(passedPath);

        // print result
        System.out.println("Resolved Path:"
                + resolvedPath);
    }
}
