import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class HighScoreTable3 {
	private int capacity;
	private int size = 0;
	private ArrayList <Player> ar;
	
	public HighScoreTable3 () {
		this.capacity = 10;
		this.ar = new ArrayList <> ();
	}
	
	public HighScoreTable3(int capacity){
		this.capacity = capacity;
		try {
			this.ar = new ArrayList <> (this.capacity);
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
		int index = 0;
		int size = this.size;
		/*
		 * if (score < 0) { throw new IllegalArgumentException(); }
		 */
		if (this.size == 0 ) {
			this.ar.add(p);
			this.size++;
		}else if (score < this.ar.get(size - 1).getPlayerScore()&& this.size == this.capacity){
			return;
		}else {
			while (index < size) {
				if (score > this.ar.get(index).getPlayerScore()) {
					this.ar.add(index,p);
					this.size++;
					break;
				}else if (score == this.ar.get(index).getPlayerScore()) {
					this.ar.add(index + 1,p);
					this.size++;
					break;
				}
				
				index++;
				if (index == this.size) {
					this.ar.add(p);
					this.size++;
				}
			}
			
			if (size == this.capacity) {
				this.ar.remove(size);
				this.size--;
			}
		}
		
	}
	
	
	public String getName (int i) throws NullPointerException{
		return ar.get(i).getPlayerName();
	}
	
	public int getScore (int i) throws NullPointerException{
		return ar.get(i).getPlayerScore();
	}
	
	public void write (File file) throws FileNotFoundException {
		PrintStream file2 = new PrintStream (file);
		
		file2.println(this.capacity);
		
	}
	
	
}
