package msci121;

public class Point {
	private int x;
	private int y;
	
	public Point(int x1, int y1) {
		this.x = x1;
		this.y = y1;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public double getSlope (Point other) {
		int x2 = other.getX();
		int y2 = other.getY();
		double m;
		m = (y2 - this.y)/(x2 - this.x);
		return m;
	}

}
