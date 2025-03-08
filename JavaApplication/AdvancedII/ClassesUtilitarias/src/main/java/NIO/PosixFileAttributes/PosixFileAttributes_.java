package NIO.PosixFileAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.Set;

/**
 * https://www.javatips.net/api/java.nio.file.attribute.posixfileattributes
 */
public class PosixFileAttributes_ {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("C:\\Users\\davi\\Documents\\temp\\metadata.txt");
            Files.deleteIfExists(path);
            Files.createFile(path);
            BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
            BasicFileAttributes basicAttributes = basicView.readAttributes();
            boolean isDirectory = basicAttributes.isDirectory();
            FileTime lastModifiedTime = basicAttributes.lastModifiedTime();
            System.out.println(isDirectory);
            System.out.println(lastModifiedTime);
            PosixFileAttributeView posixView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
            PosixFileAttributes posixAttributes = posixView.readAttributes();
            GroupPrincipal group = posixAttributes.group();
            Set<PosixFilePermission> permissions = posixAttributes.permissions();
            permissions.add(PosixFilePermission.OWNER_EXECUTE);
            posixView.setPermissions(permissions);
            System.out.println(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
