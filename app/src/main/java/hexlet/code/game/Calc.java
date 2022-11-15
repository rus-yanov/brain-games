package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    private static final String NAME_INPUT = Cli.greet();
    static final int MAX_ATTEMPT = 3;
    static final int MIN = 0;
    static final int MAX = 100;
    static final int MULTIPLY_INDEX = 1;
    static final int SUM_INDEX = 2;
    static final int DIFF_INDEX = 3;

    public static void game() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Whats is the result of the expression?");

        int counter = 0;
        while (counter < MAX_ATTEMPT) {
            int num1 = Engine.getRandomNum(MIN, MAX);
            int num2 = Engine.getRandomNum(MIN, MAX);
            String operand = getArithmeticOperand();
            assert operand != null;
            String result = getResult(num1, num2, operand);
            Engine.question(num1 + " " + operand + " " + num2);
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

    public static String getArithmeticOperand() {
        return switch (Engine.getRandomNum(MULTIPLY_INDEX, DIFF_INDEX)) {
            case MULTIPLY_INDEX -> "*";
            case SUM_INDEX -> "+";
            case DIFF_INDEX -> "-";
            default -> null;
        };
    }

    public static String getResult(int num1, int num2, String operand) {
        return switch (operand) {
            case "*" -> Integer.toString(num1 * num2);
            case "+" -> Integer.toString(num1 + num2);
            case "-" -> Integer.toString(num1 - num2);
            default -> null;
        };
    }
}
