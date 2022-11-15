package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static String greet() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = sc.nextLine();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }
}
