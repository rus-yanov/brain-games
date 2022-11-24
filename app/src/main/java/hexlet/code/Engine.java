package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;

    public static void run(String description, String[][] roundsData) {
        Scanner sc = new Scanner(System.in);
        String userName = Cli.greet(); // printing standard greeting
        System.out.println(description); // printing game's description

        for (var row : roundsData) {
            String result = row[0];
            String question = row[1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String input = sc.next();

            if (input.equals(result)) {
                // in case input was correct
                System.out.println("Correct!");
            } else {
                // in case input was wrong
                System.out.println("'" + input + "'" + " is wrong answer ;(. Correct answer was '" + result + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
        sc.close();
    }
}
