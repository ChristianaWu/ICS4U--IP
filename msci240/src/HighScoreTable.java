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
		
	}
	
	
	
}
