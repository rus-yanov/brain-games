package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class GCD {
    private static final String NAME_INPUT = Cli.greet();
    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final String DESCRIPTION =
            "Find the greatest common divisor of given numbers.";

    public static void game() {
        Engine.printDescription(DESCRIPTION);
        Scanner sc = new Scanner(System.in);
        int maxAttempt = 3;
        int counter = 0;
        while (counter < maxAttempt) {
            int num1 = Engine.makeRandomNum(MIN, MAX);
            int num2 = Engine.makeRandomNum(MIN, MAX);
            String result = Integer.toString(gcd(num1, num2));
            Engine.question(num1 + " " + num2);
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

    // implementing Euclid's algorithm to get GCD
    public static int gcd(int n1, int n2) {
        return n2 == 0 ? n1 : gcd(n2, n1 % n2);
    }
}
