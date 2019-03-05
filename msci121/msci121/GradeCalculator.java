/*
 * Christiana Wu
 * 20767703
 * Problem 2 Assignemnt 5
 * March 4, 2019 
 * Input the name and grades Output the average 
 * This program will take the input from the user and then use .next to get the tokens to solve for the 
 * average grade 
 */
package msci121;

import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {
		//Objects 
		Scanner input = new Scanner (System.in);
		
		//Variables 
		String name;
		double avg;
		int grade, sum = 0, numbGrades;
		
		System.out.print("Enter a student record: ");
		name = input.next(); // get the name not the entire string 
		numbGrades = input.nextInt(); // this will help fix a loop 
		for (int i = 1; i <= numbGrades; i++) {// This will all the grades listed and then add them together
			grade = input.nextInt();
			sum = sum + grade;
		}
		
		avg = (double) sum/numbGrades; // find the sum but since both the numbers are ints you just have to cast it 
		
		System.out.println(name + "'s average grade is " + avg);
		
		input.close();// closing the scanner

	}

}
