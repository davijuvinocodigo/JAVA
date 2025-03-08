package Random;

// https://www.baeldung.com/java-random-string
// https://github.com/eugenp/tutorials/tree/master/core-java-modules

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class RandomStringTest {

    //simple and generate a random String bounded to 7 characters:

    @Test
    public void givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        System.out.println(generatedString);

        String generatedString2 = RandomStringUtils.random(10);
        System.out.println(generatedString2);

        String generatedString3 = RandomStringUtils.randomAlphabetic(10);
        System.out.println(generatedString3);

        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString4 = RandomStringUtils.random(length, useLetters, useNumbers);
        System.out.println(generatedString4);

    }
}
