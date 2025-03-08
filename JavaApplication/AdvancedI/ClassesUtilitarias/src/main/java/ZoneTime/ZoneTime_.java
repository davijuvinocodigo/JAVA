package ZoneTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneTime_ {
    public static void main(String[] args) {
        System.out.println(ZoneId.systemDefault());
        System.out.println(ZonedDateTime.now());
    }
}
