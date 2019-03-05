/*
 * Christiana Wu = 207067703 
 * Assignement 4 - problem 3 
 * Feb 2, 2019
 * This will product a pattern 
 * input a height and output the pattern 
 */
package msci121;

public class pattern3 {
	//constant
	public static final int HEIGHT = 5; 
	public static final int HEIGHT2 = 3; 

	public static void main(String[] args) {
		
		printPattern(HEIGHT);
		System.out.println();
		printPattern(HEIGHT2);
	

	}
	
	// This will produce the pattern based on the height/ number of rows that is wanted 
	public static void printPattern (int numbRows){
		//Variables  
		int rows = numbRows;
		int sStar = 0;
		
		//This is the looping that will print the symbol based on row and column 
		for (int row = 0; row<=(numbRows-1); row++){
			 for (int col = 1; col<=(numbRows*4); col++){
				 //This determines when to print the different symbols 
				 if (col>sStar && col<= (sStar+ rows) || col > ((numbRows*4)-(sStar + rows)) && col<=((numbRows*4)-sStar)){
					 System.out.print("$");
				 } else {
					 System.out.print("*");
				 }
			 }
			 System.out.println();
			 //This changes the different stating starts in respect to the row
			 rows--;
			 sStar+=2;
		  }
		}

}
