package hexlet.code;

import java.util.Random;

public class Utils {
    // getting random int
    public static int makeRandomNum(int min, int max) {
        int diff = max - min;
        Random rand = new Random();
        int randomNum = rand.nextInt(diff + 1);
        randomNum += min;
        return randomNum;
    }
}
