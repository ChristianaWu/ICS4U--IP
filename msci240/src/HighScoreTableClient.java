import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HighScoreTableClient {

	public static void main(String[] args) throws IllegalArgumentException, FileNotFoundException {
		LinkedIntList x = new LinkedIntList();
		x.add(2);
		x.add(4);
		x.add(18);
		x.add(1);
		x.add(30);
		x.add(-4);
		x.add(5);
		x.add(58);
		x.add(21);
		x.add(13);
		x.add(19);
		x.add(27);
//		
//		x.removeRange(0, 3);
//		System.out.println(x.toString());
		
//		LinkedIntList x = null;
		
		x.compress(5);
		System.out.println(x.toString());
//		x.compress(3);
//		System.out.println(x.toString());
	}

}
