/*
 * Christiana Wu
 * 20767703
 * Problem 4 Assignemnt 6
 * March 9, 2019 
 * a) Input none Output the guess that the computer gen 
 * 	  The computer will gen a random number between 1 - 50 when it guesses 48 and > then it will 
 * 	  stop the program and print out how man y guesses it took to guess a number 48 and > 
 * b) Input y or n Output the riddle 
 * 	  The computer will print the riddle and ask if the user wants to hear it again if not then this 
 * 	  program will stop 
 */

package msci121;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		makeGuesses();
		sally();

	}
	public static void makeGuesses () {
		int genNumb, sumOfGeuesses = 0;
		do {
			genNumb = (int) (Math.random() * ((50) + 1)) + 1; // Gen random number for 1- 50 inclusive 
			System.out.println("guess = " + genNumb);
			sumOfGeuesses++; // counting the number of guesses 
		}while (genNumb < 48);
		System.out.println("total guesses: " + sumOfGeuesses); 
		
	}
	
	public static void sally() {
		Scanner input = new Scanner (System.in);
		String userRes;
		
		do { 
			System.out.print("She sells seashells by the seashore. \nDo you want to hear it again: ");
			userRes = input.nextLine();	
		}while (userRes.equalsIgnoreCase("y"));
		
	}
}
