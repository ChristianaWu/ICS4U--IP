/*
 * Christiana Wu
 * 20767703
 * Assignment 9 part 2
 * 04,1,2019
 * input 2 coordinates out put the slope 
 * Asks for the coordinates for 2 points and then produces the slope this is done by creating objects 
 * and the getSlope method
 */
package msci121;

import java.util.Scanner;

public class PointClient {
	public static void main (String args []) {
		int x1,y1,x2,y2; 
		Scanner input = new Scanner (System.in);
		
		System.out.print("What is the first's point coordinates? \nEnter the x-coordinates: ");
		x1 = input.nextInt();
		
		System.out.print("Enter the y-coordinates: ");
		y1 = input.nextInt();
		
		System.out.print("What is the second's point coordinates? \nEnter the x-coordinates: ");
		x2 = input.nextInt();
		
		System.out.print("Enter the y-coordinates: ");
		y2 = input.nextInt();
		
		Point p1 = new Point (x1,y1);
		Point p2 = new Point (x2, y2);
		
		System.out.println("The slope is: " + p1.getSlope(p2));
		
	}
}
