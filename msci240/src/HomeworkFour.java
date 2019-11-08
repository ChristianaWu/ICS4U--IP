/*
 * Christiana Wu
 * November 1, 2019 
 * Homework 4
 * Input this is modulus that therefore tere is not direct input to these but 
 * when the method is called there are int inouts and a list input 
 * Output these are strings that are print
 */

import java.util.ArrayList;
import java.util.List;

public class HomeworkFour {
	public static void writeNums (int n ) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		if (n == 1) {
			System.out.print(n);
		}else {
			writeNums (n-1);
			System.out.print(", " + (n));
		}
	}
	
	public static void writeSquares (int n) {
		int p;
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		if (n == 1) {
			System.out.print(n);
		}else {
			if (n%2 != 0) {
				p = (int)Math.pow(n, 2);
				System.out.print(p + ", ");
				writeSquares(n-1);
			}else {
				writeSquares(n-1);
				p = (int)Math.pow(n, 2);
				System.out.print(", "+ p);
			}
			
		}
	}
	
	public static void subsets (List<String> x) {
		subsets(x,0);
		
	}
	
	private static void subsets(List<String> x, int length) {
		if (length == x.size()) {
			System.out.println(x.toString());
		}else {
			length++;
			subsets(x,length);
			List<String> c= new ArrayList<String>();
			c.addAll(x);
			c.remove(length-1);
			subsets (c,length-1);
		}
	}
}
