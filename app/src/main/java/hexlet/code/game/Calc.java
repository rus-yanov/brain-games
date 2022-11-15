package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    private static final String nameInput = Cli.greet();
    static final int maxAttempt = 3;
    static final int min = 0;
    static final int max = 100;
    static final int multiplyIndex = 1;
    static final int sumIndex = 2;
    static final int diffIndex = 3;

    public static void game() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Whats is the result of the expression?");

        int counter = 0;
        while (counter < maxAttempt) {
            int num1 = Engine.getRandomNum(min, max);
            int num2 = Engine.getRandomNum(min, max);
            String operand = getArithmeticOperand();
            assert operand != null;
            String result = getResult(num1, num2, operand);
            Engine.question(num1 + " " + operand + " " + num2);
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

    public static String getArithmeticOperand() {
        return switch (Engine.getRandomNum(multiplyIndex, diffIndex)) {
            case multiplyIndex -> "*";
            case sumIndex -> "+";
            case diffIndex -> "-";
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