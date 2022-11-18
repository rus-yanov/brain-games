package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final int MIN = 0;
    private static final int MAX = 10000;
    private static final String DESCRIPTION =
            "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void runGame() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i += 1) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(DESCRIPTION, roundsData);
    }

    private static String[] generateRoundData() {
        int num = Utils.makeRandomNum(MIN, MAX);
        String result = isEven(num) ? "yes" : "no";
        String question = Integer.toString(num);

        return new String[]{result, question};
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
