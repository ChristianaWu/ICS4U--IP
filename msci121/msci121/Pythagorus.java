/*
 * Christiana Wu - 20767703
 * Feb 3, 2019
 * Homework 4 - problem 4 
 * This will calculate the hypotenuse of a triangle 
 * input 2 side lengths  output the hypotenuse 
 */

package msci121;

import java.util.Scanner;

public class Pythagorus {

	public static void main(String[] args) {
		//Variables 
		double a, b, c;
		
		Scanner input = new Scanner(System.in);
		
		//intro 
		System.out.println("Given the lentgth of the other twho sieds (a and b), \n this program gives the lentgth of the hypotneuse (c).");
		
		//Inputing information 
		System.out.print("Please give the value of a: ");
		a = input.nextDouble();
		
		System.out.print("Please give the vlause of b: ");
		b = input.nextDouble();
		
		//Math 
		c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		
		//final line 
		System.out.println("The hypotenuse has length " + c);
		
		input.close();

	}

}
