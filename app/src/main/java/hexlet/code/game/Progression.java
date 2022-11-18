package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MIN = 1;
    private static final int MAX = 10;
    private static final String DESCRIPTION =
            "What number is missing in the progression?";

    public static void runGame() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i += 1) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(DESCRIPTION, roundsData);
    }

    private static String[] generateRoundData() {
        int first = Utils.makeRandomNum(MIN, MAX);
        int step = Utils.makeRandomNum(MIN, MAX);
        int hiddenMemberIndex = Utils.makeRandomNum(0, PROGRESSION_LENGTH - 1);

        String[] progression = makeProgression(first, step, PROGRESSION_LENGTH);
        String result = progression[hiddenMemberIndex];

        progression[hiddenMemberIndex] = "..";
        String question = String.join(" ", progression);

        return new String[]{result, question};
    }

    public static String[] makeProgression(int init, int step, int length) {
        // implementing progression
        String[] progression = new String[length];

        for (int i = 0; i < length; i += 1) {
            progression[i] = Integer.toString(init + i * step);
        }

        return progression;
    }
}