/*
 * Christiana Wu
 * 20767703
 * Assignment 9 part 1
 * 04,1,2019
 * input nothing out put nothing 
 * This class just just stores the mothods that this object can use. 
 */
package msci121;

public class Point {
	private int x;
	private int y;
	public Point () {
		this (0,0);
	}
	public Point(int x1, int y1) {
		this.x = x1;
		this.y = y1;
	}
	
	public void setLocation(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public double getSlope (Point other) throws IllegalArgumentException{
		double x2 = other.x;
		double y2 = other.y;
		double m;
		m = (y2 - this.y)/(x2 - this.x);
		return m;
	}

}
