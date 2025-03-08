package Duration;

import java.time.Duration;
import java.time.LocalDateTime;

public class Duration_ {
    public static void main(String[] args) {
        Duration between = Duration.between(LocalDateTime.now(), LocalDateTime.now().plusYears(2));
        System.out.println(between);
    }
}
