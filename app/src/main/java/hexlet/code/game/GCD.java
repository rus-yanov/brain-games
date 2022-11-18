package hexlet.code.game;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class GCD {
    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final String DESCRIPTION =
            "Find the greatest common divisor of given numbers.";

    public static void runGame() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i += 1) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(DESCRIPTION, roundsData);
    }

    private static String[] generateRoundData() {
        int num1 = Utils.makeRandomNum(MIN, MAX);
        int num2 = Utils.makeRandomNum(MIN, MAX);
        String result = Integer.toString(gcd(num1, num2));
        String question = num1 + " " + num2;

        return new String[]{result, question};
    }

    // implementing Euclid's algorithm to get GCD
    public static int gcd(int n1, int n2) {
        return n2 == 0 ? n1 : gcd(n2, n1 % n2);
    }
}
