/*
 * Christiana Wu
 * 20767703
 * Problem 3 Assignemnt 5
 * March 4, 2019 
 * Input guess Output if it is higher or lower to compared to the number that the computer that has genrated  
 * This is a game the comouter will gen a number in a range and then the user is trying to guess the number. 
 * The computer will take in user guess and then tell the user if it is higher or lower compared ot the number
 * Then ask you if you want to play the game again. if no then it will output the tot games tot guess max guess and avg guess.
 */
package msci121;

import java.util.Scanner;

public class Guess {
	public static final int MAX = 100; 
	public static void main(String[] args) {
		//object 
		Scanner input = new Scanner (System.in);
		
		//Variables 
		String responce;
		int numbGames = 1, sumGuesses, maxGuess, newGuess;
		
		intro();
		sumGuesses = game(input);
		maxGuess = sumGuesses;
		
		System.out.print("Do you want to play again?: ");
		responce = input.next();
		
		while (responce.charAt(0) == 'y'|| responce.charAt(0)== 'Y') {
			numbGames++;
			newGuess = game(input); // Check if the game will be replayed 
			sumGuesses += newGuess;
			if (newGuess > maxGuess) {
				maxGuess = newGuess;
			}
			System.out.print("Do you want to play again?: ");
			responce = input.next();
		}
		
		overAll(numbGames, sumGuesses, maxGuess);
		
	}
	
	public static void intro () {//Instructions for the game
		System.out.println("This program allows you to play a guessing game.I will think of a number \nbetween 1 and 100 and will allow you to guess until you get it.For each guess, \nI will tell you whether theright answer is higher or lower than your guess. \n \n \nI am thinking of a number...");

	}
	
	public static int game (Scanner input) {
		int guess, numbGuess = 0;
		int genNumb = (int) (Math.random() * ((MAX) + 1)) + 1;	//Gen a random number that the user wil guess
		System.out.println(genNumb);
		do {
			System.out.print("Your guess? ");
			guess = input.nextInt();// Take user guess
			if(guess > genNumb) { //Compare it to the gen number and have the system print out if it is higher or lower 
				System.out.println("Lower");
			}else if (guess < genNumb) {
				System.out.println("Highter");
			}
			numbGuess++; // tracking the guesses
		}while (guess != genNumb);
		
		System.out.println("You got this right in " + numbGuess + " guesses");
		return numbGuess;
	}
	
	public static void overAll (int numbGames, int sumGuesses, int maxGuess) {
		double avg;
			avg = (double) sumGuesses/numbGames; // if not then the print out the gmaes guesses max guess and avg 
			System.out.println("Total game = " + numbGames + "\nTotal guesses = " + sumGuesses + "\nGuesses/Games = " + avg + "\nMax Guesses = " + maxGuess);
	}

}
