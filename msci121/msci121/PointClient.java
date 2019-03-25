package msci121;

import java.util.Scanner;

public class PointClient {
	public static void main (String args []) {
		int x1,y1,x2,y2; 
		Scanner input = new Scanner (System.in);
		
		System.out.print("What is the first's point coordnates? \nEnter the x-coordnate: ");
		x1 = input.nextInt();
		
		System.out.print("Enter the y-coordnate: ");
		y1 = input.nextInt();
		
		System.out.print("What is the second's point coordnates? \nEnter the x-coordnate: ");
		x2 = input.nextInt();
		
		System.out.print("Enter the y-coordnate: ");
		y2 = input.nextInt();
		
		Point p1 = new Point (x1,y1);
		Point p2 = new Point (x2, y2);
		
		System.out.println("The slope is: " + p1.getSlope(p2));
		
	}
}
