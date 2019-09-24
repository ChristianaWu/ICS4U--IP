import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class HighScoreTable {
	private int capacity;
	private ArrayList <Player> ar;
	
	public HighScoreTable () {
		this.capacity = 10;
		this.ar = new ArrayList <>(this.capacity);
	}
	
	public HighScoreTable(int capacity) throws IllegalArgumentException {
		this.capacity = capacity;
		this.ar = new ArrayList <>(this.capacity);
	}
	
	public int getSize() {
		return ar.size();
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void add (String name, int score) throws IllegalArgumentException {
		Player p = new Player (name,score);
		int index = 0;
		
		if (ar.size() == this.capacity) {
			for (int i = ar.size(); i >= 0; i--) {
				if (score > ar.get(i).getScore()) {
					index = i;
				}else if (score == ar.get(i).getScore()) {
					index = i+1;
				}
			}
			ar.add(index, p);
			ar.remove(ar.size()-1);
		}
		ar.add(p);
	}
	
	public String getName (int i) {
		return ar.get(i).getName();
	}
	
	public int getScore (int i) {
		return ar.get(i).getScore();
	}
	
	public void write (File file) {
		PrintStream file2 = new PrintStream (file);
	}
	
	
}
