import java.io.File;
import java.io.FileNotFoundException;

public class HighScoreTableClient {

	public static void main(String[] args) throws IllegalArgumentException, FileNotFoundException {
		File file = new File ("High Score.txt");
     	HighScoreTable x2 = HighScoreTable.read(file);
     	
     	System.out.println(x2.getCapacity());
     	System.out.println(x2.size());
     	System.out.println(x2.getName(0) + "," + x2.getScore(0));
		
		
	}

}
