package hexlet.code;

import hexlet.code.game.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        Scanner sc = new Scanner(System.in);
        System.out.print("Your choice: ");
        int input = sc.nextInt();

        switch (input) {
            case 0 -> System.out.println("Exit");
            case 1 -> Cli.greet();
            case 2 -> Even.game();
            case 3 -> Calc.game();
            case 4 -> GCD.game();
            case 5 -> Progression.game();
            case 6 -> Prime.game();
            default -> System.out.println("Something wrong");
        }
        sc.close();
    }
}
