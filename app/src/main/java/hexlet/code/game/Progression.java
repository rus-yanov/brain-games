package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Scanner;

public class Progression {
    private static final String NAME_INPUT = Cli.greet();
    private static final int LENGTH = Engine.makeRandomNum(8, 12);
    private static final int INIT = Engine.makeRandomNum(0, 100);
    private static final int STEP = Engine.makeRandomNum(1, 10);
    private static final String DESCRIPTION =
            "What number is missing in the progression?";

    public static void game() {
        Engine.printDescription(DESCRIPTION);
        Scanner sc = new Scanner(System.in);
        int maxAttempt = 3;
        int counter = 0;
        while (counter < maxAttempt) {
            String[] randomProgression = makeProgression(INIT, STEP, LENGTH);
            int index = makeIndex(randomProgression);
            String result = returnResult(randomProgression, index);
            String progressionWithVoid = makeProgressionWithVoid(randomProgression, index);
            Engine.question(progressionWithVoid);
            String input = sc.nextLine();

            if (input.equals(result)) {
                Engine.correct();
                counter++;
            } else {
                Engine.endGame(input, result, NAME_INPUT);
                return;
            }
        }
        Engine.congrats(counter, maxAttempt, NAME_INPUT);
        sc.close();
    }

    public static String[] makeProgression(int init, int step, int length) {
        // implementing progression
        int lastNumInRow = length * step + init;
        int[] intArray = new int[length];

        int j = 0;
        for (int i = init; i < lastNumInRow; i += step) {
            intArray[j] = i;
            j++;
        }

        // converting progression of ints to progression of Strings
        String[] strArray = new String[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            strArray[i] = String.valueOf(intArray[i]);
        }

        return strArray;
    }

    public static int makeIndex(String[] progression) {
        // getting index of random number
        return Engine.makeRandomNum(0, progression.length - 1);
    }

    public static String returnResult(String[] progression, int index) {
        // returning chosen random number for the right answer
        return progression[index];
    }

    public static String makeProgressionWithVoid(String[] progression, int index) {
        // replacing chosen number with ".."
        progression[index] = "..";

        // converting to String and getting rid of commas
        String unedited = Arrays.toString(progression);
        String array = "";
        for (int i = 0; i < unedited.length(); i++) {
            if (unedited.charAt(i) != ',' && unedited.charAt(i) != '[' && unedited.charAt(i) != ']') {
                array += unedited.charAt(i);
            } else {
                array += "";
            }
        }

        return array;
    }
}
