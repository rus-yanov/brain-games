package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class Even {
    private static final String NAME_INPUT = Cli.greet();
    static final int MAX_ATTEMPT = 3;
    static final int MIN = 0;
    static final int MAX = 10000;

    public static void game() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int counter = 0;
        while (counter < MAX_ATTEMPT) {
            int num = Engine.getRandomNum(MIN, MAX);
            String result = getResult(num);
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
        Engine.congrats(counter, MAX_ATTEMPT, NAME_INPUT);
        sc.close();
    }

    public static String getResult(int num) {
        return num % 2 == 0 ? "yes" : "no";
    }
}
