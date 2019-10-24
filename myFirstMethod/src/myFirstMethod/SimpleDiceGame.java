package myFirstMethod;
import java.util.*;
public class SimpleDiceGame {

	
	static int money;
	static String userName;
	static String password;
	static String again;
	static Scanner in = new Scanner(System.in);
	static Random random = new Random();

	public static void main(String[] args) {

		// Username input
		
		System.out.println("Please enter your username: ");
		userName=in.nextLine();
		money=1000;
		System.out.println("Welcome " + userName + "!");
		System.out.println("You have: $" + money);
		rollDice();
		playAgain();
	
		}
	
	
	
	public static void rollDice()
	{
		System.out.println("What number would you like to bet on? (1-6) ");
		int betRoll = in.nextInt();
		
		while (( betRoll> 6 | betRoll <1 ))
		{
			System.out.println("You can only bet on a number between 1-6" + "." + 
		" Please enter the number you would like to bet on: ");
		betRoll = in.nextInt();
		}
		System.out.println("Your current balance is: $" + money);
		System.out.println("How much would you like to bet? ");
		
		int betMoney = in.nextInt();
		while(money < betMoney) 
		{
		System.out.println("You dont have that much money!" + "\n" + " You have: $"+ money + "." +
		"\n Please enter your bet: ");
		betMoney = in.nextInt();
		
		}
		int dice;
		dice = random.nextInt(6)+1;
		System.out.println("The dice roll's: " + dice + " " + "!");
		if(betRoll==dice)
		{
			System.out.println("You won: $" + 2*betMoney + "!");
			money = money + 2*betMoney;
			System.out.println("Your current balance is: $" + money);
		}
		
		else
		{
			System.out.println("You lost!");
			money = money - betMoney;
			System.out.println("Your current balance is: $"+ money);
		}
		
		if(money <= 0)
		{
			System.out.println("Game over: You are broke! ");
		}
		
	}
	public static void playAgain() {
	Scanner in = new Scanner(System.in);
	System.out.println("Would you like to play again? ");
	again = in.nextLine();
	
	if(again =="yes")
	{
		rollDice();
	}
	}
}
