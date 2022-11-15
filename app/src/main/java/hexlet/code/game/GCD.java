package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class GCD {
    private static final String nameInput = Cli.greet();
    static final int maxAttempt = 3;
    static final int min = 0;
    static final int max = 100;

    public static void game() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Find the greatest common divisor of given numbers.");

        int counter = 0;
        while (counter < maxAttempt) {
            int num1 = Engine.getRandomNum(min, max);
            int num2 = Engine.getRandomNum(min, max);
            String result = Integer.toString(getResult(num1, num2));
            Engine.question(num1 + " " + num2);
            String input = sc.nextLine();

            if (input.equals(result)) {
                Engine.correct();
                counter++;
            } else {
                Engine.endGame(input, result, nameInput);
                return;
            }
        }
        Engine.congrats(counter, maxAttempt, nameInput);
        sc.close();
    }

    // implementing Euclid's algorithm to get GCD
    public static int getResult(int n1, int n2) {
        return n2 == 0 ? n1 : getResult(n2, n1 % n2);
    }
}
