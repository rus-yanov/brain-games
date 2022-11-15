package hexlet.code;

import java.util.Random;

public class Engine {

    // asking question and giving answer String
    public static void question(String task) {
        System.out.println("Question: " + task);
        System.out.print("Your answer: ");
    }

    // in case giving answer is correct
    public static void correct() {
        System.out.println("Correct!");
    }

    // in case giving answer is wrong
    public static void endGame(String wrongAnswer, String correctAnswer, String name) {
        System.out.println("'" + wrongAnswer + "'" + " is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + name + "!");
    }

    // in case all 3 giving answers were correct
    public static void congrats(int counter, int maxAttempt, String name) {
        if (counter == maxAttempt){
            System.out.println("Congratulations, " + name + "!");
        }
    }

    // getting random int
    public static int getRandomNum(int min, int max){
        int diff = max - min;
        Random rand = new Random();
        int randomNum = rand.nextInt(diff + 1);
        randomNum += min;
        return randomNum;
    }
}
