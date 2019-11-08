
public class RecursiveMethods {
	public static void starString (int n) {
		if (n == 0 ) {
			System.out.print("*");
		}else {
			starString(n-1);
			starString(n-1);
		}
	}
	
}
