package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;

    public static void run(String description, String[][] roundsData) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = sc.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(description);

        for (var row : roundsData) {
            String result = row[0];
            String question = row[1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String input = sc.next();

            if (input.equals(result)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + input + "'" + " is wrong answer ;(. Correct answer was '" + result + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
        sc.close();
    }
}
