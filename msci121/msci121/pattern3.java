/*
 * Christiana Wu = 207067703 
 * Assignement 4 - problem 3 
 * Feb 2, 2019
 * This will product a pattern 
 * input a height and output the pattern 
 */
package msci121;

import java.util.Scanner;

public class pattern3 {
	
	public static int height; 

	public static void main(String[] args) {
		//THis allows the user to input a height
		System.out.print("The hegiht of this the pattern is: ");
		Scanner input = new Scanner(System.in);
		height = input.nextInt();
		
		printPattern(height);
		
		input.close();

	}
	
	// This will produce the pattern based on the height/ number of rows that is wanted 
	public static void printPattern (int numbRows){
		  int rows = numbRows;
		  int sStar = 0;
		  for (int row = 0; row<=(numbRows-1); row++){
		    for (int col = 1; col<=(numbRows*4); col++){
		      if (col>sStar && col<= (sStar+ rows) || col > ((numbRows*4)-(sStar + rows)) && col<=((numbRows*4)-sStar)){
		        System.out.print("$");
		      } else {
		        System.out.print("*");
		      }
		  }
		    System.out.println();
		    rows--;
		    sStar+=2;
		  }
		}

}
