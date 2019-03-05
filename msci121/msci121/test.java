package msci121;
import java.util.Scanner;

public class test { 
	public static void main( String[] args ) { 
		int x= NumbHeads(5);
		
		System.out.println(x);
	}
	
	public static void pattern (int numbRows) {
		for (int row =1; row<=numbRows; row++) {
			for (int s = 1; s<=numbRows-row; s++) {
				System.out.print(" ");
			}
			for (int n = 1; n<=row; n++) {
				System.out.print(row);
			}
			System.out.println();
		}
	}
	
	public static int NumbHeads (int numbFlips) {
		int numbHeads=0;
		int x;
		for (int i = 1; i <= numbFlips; i++) {
			x = (int) (Math.random() * ((1-0) + 1))+0;
			if (x == 1) {
				System.out.print("H");
				numbHeads++;
			}else {
				System.out.print("T");
			}
		}
		
		return numbHeads;
	}

}
