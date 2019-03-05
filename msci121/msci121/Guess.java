package msci121;

import java.util.Scanner;

public class Guess {
	public static final int MAX = 100; 
	public static void main(String[] args) {
		//object 
		Scanner input = new Scanner (System.in);
		System.out.println("This program allows you to play a guessing game.I will think of a number \nbetween 1 and 100and will allow you to guess until you get it.For each guess, \nI will tell you whether theright answer is higher or lower than your guess. \n \n \nI am thinking of a number...");
		
	}
	
	public static void intro () {
		int genNumb = (int) Math.random() * (MAX) + 1;	
	}
	
	public static void input (Scanner input, int genNumb) {
		intro();
		int guess, numbGuess = 0;
		do {
			System.out.println("Your guess? ");
			guess = input.nextInt();
			numbGuess++;
		}while (guess != genNumb);
		
		//System.out.printfn("You got this right in %d", numbGuess);
		
		
	}
	
	public static void overAll () {
		
	}

}
