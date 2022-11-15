package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class Prime {
    private static final String nameInput = Cli.greet();
    static final int maxAttempt = 3;
    static final int min = 0;
    static final int max = 100;

    public static void game() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        int counter = 0;
        while (counter < maxAttempt) {
            int num = Engine.getRandomNum(min, max);
            String result = getResult(num);
            Engine.question(num + "");
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

    public static String getResult(int num) {
        if (num <= 1) {
            return "no";
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
