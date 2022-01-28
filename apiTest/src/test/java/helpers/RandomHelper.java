package helpers;

import java.util.Random;

public class RandomHelper {

    public static Integer getRandomNumber(int length) {
        String str = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            str = str + random.nextInt(10);
        }
        return Integer.valueOf(str);
    }
}
