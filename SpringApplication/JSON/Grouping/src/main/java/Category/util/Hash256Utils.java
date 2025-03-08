package Category.util;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Hash256Utils {
    public static String generateHash256String(String value){
        return Hashing.sha256().hashString(value, StandardCharsets.UTF_8).toString();
    }
}
