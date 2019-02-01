package msci121;

import java.util.Scanner;

public class pattern3 {
	
	public static int height; 

	public static void main(String[] args) {
		
		System.out.print("The hegiht of this the pattern is: ");
		Scanner input = new Scanner(System.in);
		height = input.nextInt();
		
		printPattern(height);
		
		input.close();

	}
	
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
