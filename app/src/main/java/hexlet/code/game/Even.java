package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class Even {
    private static final String NAME_INPUT = Cli.greet();
    private static final int MIN = 0;
    private static final int MAX = 10000;
    private static final String DESCRIPTION =
            "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void game() {
        Engine.printDescription(DESCRIPTION);
        Scanner sc = new Scanner(System.in);
        int maxAttempt = 3;
        int counter = 0;
        while (counter < maxAttempt) {
            int num = Engine.makeRandomNum(MIN, MAX);
            String result = isEven(num) ? "yes" : "no";
            Engine.question(num + "");
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

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
