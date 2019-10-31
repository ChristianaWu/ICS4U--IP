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
		int n = 0;
		if (n == x.size()-1) {
			System.out.println(x.toString());
		}else {
			List <String> y = x.subList(0, n++);
			subsets(y);
			System.out.println(y.toString());
		}
		
	}
}
