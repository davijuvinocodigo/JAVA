package ResourceBundle_;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main(String[] args) {

        Locale locale = new Locale("pt", "BR");

        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        System.out.println(bundle.getString("welcome"));
    }
}
