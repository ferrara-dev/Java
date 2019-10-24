/*
 * Author: Samuel Ferrara
 * Date: 2019-10-24
 * My first Java program consiting in a simple dice game
 *
 */

package myFirstMethod;

import java.util.Random;
import java.util.Scanner;

public class SimpleDiceGame {


	private static final String YES = "yes";
	private static int money;
    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {

       // Username input
        System.out.println("Please enter your username: ");
        String userName = in.nextLine();
        money = 1000;

        System.out.println(String.format("Welcome %s!", userName));
        System.out.println(String.format("You have: %s$" , money));

        // initialize method "rollDice"
        while (money > 0) {
            rollDice();
        }

    }

    private static int chooseDiceFace() {
		// Input från användaren angående vilket nummer man vill satsa på
		int r = 0;
		System.out.println("What number would you like to bet on? (1-6) ");
		try {
			r =  in.nextInt();
			if ((r > 6 || r < 1)) {
				System.out.println("You can only bet on a number between 1-6.");
				r =chooseDiceFace();
			}
		} catch (Exception e) {
			in.nextLine();
			r = chooseDiceFace();
		}
		return r;
	}

	private static int bet() {
		int betMoney = 0;
		System.out.println(String.format("Your current balance is: %s $" , money));
		System.out.println("How much would you like to bet? ");
		try {
			betMoney = in.nextInt();
			if (betMoney < 0 || betMoney > money) {
				System.out.println(String.format("You can only bet between 1 to %s.", money));
				betMoney =bet();
			}
		} catch (Exception e) {
			in.nextLine();
			betMoney =bet();
		}
		return betMoney;
	}

    private static void rollDice() {

        int betRoll = chooseDiceFace();
        int betMoney = bet();
        int dice = random.nextInt(6) + 1;
        System.out.println(String.format("The dice roll's: %s !", dice) );
        if (betRoll == dice) {
            int winning = 2 * betMoney;
            money = money + winning;
			System.out.println(String.format("You won: %s $!" ,winning));
            System.out.println(String.format("Your current balance is: %s $", money));
        } else {
            System.out.println("You lost!");
            money = money - betMoney;
            System.out.println(String.format("Your current balance is: %s $", money));
        }

        if (money <= 0) {
            System.out.println("Game over: You are broke! ");
			System.exit(0);
        }
		if(playAgain()) {
			rollDice();
		} else {
			System.exit(0);
		}
    }

    private static boolean playAgain() {

    	boolean r = false;
        System.out.println("Would you like to play again? ");
		String again = in.next();
        if (YES.equals(again)) {
            r = true;
        }
        return r;
    }
}
