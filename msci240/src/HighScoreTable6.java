import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;


public class HighScoreTable6 {
	private int capacity;
	private int size = 0;
	private Player [] ar;
	
	public HighScoreTable6 () {
		this.capacity = 10;
		this.ar = new Player [10];
	}
	
	public HighScoreTable6(int capacity){
		this.capacity = capacity;
		try {
			this.ar = new Player [this.capacity];
		}catch (IllegalArgumentException e) {
			
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void add (String name, int score)throws IllegalArgumentException{
		Player p = new Player (name,score);
		ArrayList<Player> list= new ArrayList<>();
		int index = 0;
		int size = this.size;
		/*
		 * if (score < 0) { throw new IllegalArgumentException(); }
		 */
		if (this.size == 0 ) {
			this.ar[0] = p;
			this.size++;
		}else if (score < this.ar[size -1].getPlayerScore() && size == this.capacity){
			return;
		}else {
			list.addAll(Arrays.asList(this.ar));
			while (index < size) {
				if (score >list.get(index).getPlayerScore()) {
					list.add(index,p);
					list.remove(list.size()-1);
					this.size++;
					break;
				}else if (score ==list.get(index).getPlayerScore()) {
					list.add(index + 1,p);
					list.remove(list.size()-1);
					this.size++;
					break;
				}
				index++;
				
				 if (index == size) { 
					list.add(index,p); 
					list.remove(list.size()-1);
				 	this.size++; 
				 }
			}
			if (size == this.capacity) { 
				this.size--; 
			}
			this.ar = list.toArray(new Player[this.size]); 
			 
		}
		
	}
	
	public String getName (int i) throws NullPointerException{
		return ar[i].getPlayerName();
	}
	
	public int getScore (int i) throws NullPointerException{
		return ar[i].getPlayerScore();
	}
	
	public void write (File file) throws FileNotFoundException {
		PrintStream file2 = new PrintStream (file);
		
		file2.println(this.capacity);
		
	}
	
	
}
