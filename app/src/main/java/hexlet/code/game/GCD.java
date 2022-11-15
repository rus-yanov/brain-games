package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class GCD {
    private static final String NAME_INPUT = Cli.greet();
    static final int MAX_ATTEMPT = 3;
    static final int MIN = 0;
    static final int MAX = 100;

    public static void game() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Find the greatest common divisor of given numbers.");

        int counter = 0;
        while (counter < MAX_ATTEMPT) {
            int num1 = Engine.getRandomNum(MIN, MAX);
            int num2 = Engine.getRandomNum(MIN, MAX);
            String result = Integer.toString(getResult(num1, num2));
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
        Engine.congrats(counter, MAX_ATTEMPT, NAME_INPUT);
        sc.close();
    }

    // implementing Euclid's algorithm to get GCD
    public static int getResult(int n1, int n2) {
        return n2 == 0 ? n1 : getResult(n2, n1 % n2);
    }
}
