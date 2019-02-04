/*
 * Christiana Wu = 207067703 
 * Assignement 4 - problem 3 
 * Feb 2, 2019
 * This will product a pattern 
 * input a height and output the pattern 
 */
package msci121;

public class pattern3 {
	
	public static final int HEIGHT = 5; 

	public static void main(String[] args) {
		
		printPattern(HEIGHT);
	

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
