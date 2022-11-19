package hexlet.code;

import hexlet.code.game.Calc;
import hexlet.code.game.Even;
import hexlet.code.game.GCD;
import hexlet.code.game.Prime;
import hexlet.code.game.Progression;

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

        final int exit = 0;
        final int greet = 1;
        final int even = 2;
        final int calc = 3;
        final int gcd = 4;
        final int progression = 5;
        final int prime = 6;

        switch (input) {
            case exit -> System.out.println("Exit");
            case greet -> Cli.greet();
            case even -> Even.runGame();
            case calc -> Calc.runGame();
            case gcd -> GCD.runGame();
            case progression -> Progression.runGame();
            case prime -> Prime.runGame();
            default -> System.out.println("Something wrong");
        }
        sc.close();
    }
}
