package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Scanner;

public class Progression {
    private static final String NAME_INPUT = Cli.greet();
    static final int MAX_ATTEMPT = 3;

    public static void game() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What number is missing in the progression?");

        int counter = 0;
        while (counter < MAX_ATTEMPT) {
            String[] randomProgression = getProgression();
            int index = getIndex(randomProgression);
            String result = getResult(randomProgression, index);
            String progressionWithVoid = getProgressionWithVoid(randomProgression, index);
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
        Engine.congrats(counter, MAX_ATTEMPT, NAME_INPUT);
        sc.close();
    }

    public static String[] getProgression() {
        // implementing progression consisting of ints
        int lengthOfProgression = Engine.getRandomNum(8, 12);
        int initNum = Engine.getRandomNum(0, 100);
        int voidBtwNums = Engine.getRandomNum(1, 10);
        int lastNumInRow = lengthOfProgression * voidBtwNums + initNum;
        int[] intArray = new int[lengthOfProgression];

        int j = 0;
        for (int i = initNum; i < lastNumInRow; i += voidBtwNums) {
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

    public static int getIndex(String[] progression) {
        // getting index of random number
        return Engine.getRandomNum(0, progression.length - 1);
    }

    public static String getResult(String[] progression, int index) {
        // returning chosen random number for the right answer
        return progression[index];
    }

    public static String getProgressionWithVoid(String[] progression, int index) {
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
