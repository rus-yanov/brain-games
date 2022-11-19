package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Calc {
    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final int MULTIPLY_INDEX = 1;
    private static final int SUM_INDEX = 2;
    private static final int DIFF_INDEX = 3;
    private static final String DESCRIPTION =
            "What is the result of the expression?";

    public static void runGame() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i += 1) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(DESCRIPTION, roundsData);
    }

    private static String[] generateRoundData() {
        int num1 = Utils.makeRandomNum(MIN, MAX);
        int num2 = Utils.makeRandomNum(MIN, MAX);
        String operand = returnArithmeticOperand();
        String result = returnResult(num1, num2, operand);
        String question = String.join(" ", Integer.toString(num1), operand, Integer.toString(num2));

        return new String[]{result, question};
    }

    public static String returnArithmeticOperand() {
        int index = Utils.makeRandomNum(MULTIPLY_INDEX, DIFF_INDEX);
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
