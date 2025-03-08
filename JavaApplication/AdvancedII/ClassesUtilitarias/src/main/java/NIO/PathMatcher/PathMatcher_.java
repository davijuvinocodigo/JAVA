package NIO.PathMatcher;

/**
 * https://www.concretepage.com/java/jdk7/example-pathmatcher-java-nio
 */

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
public class PathMatcher_ {

    public static void main(String[] args) {
        FileSystem fileSystem = FileSystems.getDefault();
        PathMatcher pathMatcher = fileSystem.getPathMatcher("glob:D:/**/*.java");
        Path path = Paths.get("D:/cp/PathMatcherExample.java");
        System.out.println(pathMatcher.matches(path));
    }}
