package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    private static final String NAME_INPUT = Cli.greet();
    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final int MULTIPLY_INDEX = 1;
    private static final int SUM_INDEX = 2;
    private static final int DIFF_INDEX = 3;
    private static final String DESCRIPTION =
            "Whats is the result of the expression?";

    public static void game() {
        Engine.printDescription(DESCRIPTION);
        Scanner sc = new Scanner(System.in);
        int maxAttempt = 3;
        int counter = 0;
        while (counter < maxAttempt) {
            int num1 = Engine.makeRandomNum(MIN, MAX);
            int num2 = Engine.makeRandomNum(MIN, MAX);
            String operand = returnArithmeticOperand();
            String result = returnResult(num1, num2, operand);
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
        Engine.congrats(counter, maxAttempt, NAME_INPUT);
        sc.close();
    }

    public static String returnArithmeticOperand() {
        int index = Engine.makeRandomNum(MULTIPLY_INDEX, DIFF_INDEX);
        return switch (index) {
            case MULTIPLY_INDEX -> "*";
            case SUM_INDEX -> "+";
            case DIFF_INDEX -> "-";
            default -> throw new RuntimeException("Unknown index:" + index);
        };
    }

    public static String returnResult(int num1, int num2, String operand) {
        return switch (operand) {
            case "*" -> Integer.toString(num1 * num2);
            case "+" -> Integer.toString(num1 + num2);
            case "-" -> Integer.toString(num1 - num2);
            default -> throw new RuntimeException("Unknown operand: " + operand);
        };
    }
}
