
public class RecursiveMethods {
	static int count = 0;
	static int numbStar;
	public static void starString (int n) {
		if (n == 0 ) {
			System.out.print("*");
		}else {
			starString(n-1);
			starString(n-1);
		}
	}
	
}
