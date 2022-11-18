package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final String DESCRIPTION =
            "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void runGame() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i += 1) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(DESCRIPTION, roundsData);
    }

    private static String[] generateRoundData() {
        int num = Utils.makeRandomNum(MIN, MAX);
        String result = isPrime(num) ? "yes" : "no";
        String question = Integer.toString(num);

        return new String[]{result, question};
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
