import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class HighScoreTable {
	private int capacity;
	private Player[] ar;
	private int size = 0;
	
	public HighScoreTable () {
		this.capacity = 10;
		this.ar = new Player[this.capacity];
	}
	
	public HighScoreTable(int capacity){
		this.capacity = capacity;
		if(this.capacity < 0) {
			throw new IllegalArgumentException();
		}
		this.ar = new Player[this.capacity];
	}
	
	public int size() {
		return this.size;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void add (String name, int score){
		Player p = new Player (name,score);
		int index = 0;
		Player holder, temp;
		
		if (score < 0) {
			 throw new IllegalArgumentException();
		}else {
			 for (int i = 0; i < this.size; i++) {
				 if (score < this.ar[this.size -1].getScore()) {
					 break;
				 }
				 
				 if (this.ar[i].getScore() < score) {
					 holder = this.ar[i];
					 this.ar[i] = p;
					 
					 for (int n = i+1; n < this.size; n++) {
						 if (n == this.size-1) {
							 break;
						 }
						 temp = this.ar[n];
						 this.ar[n] = holder;
						 holder = temp;
						 
						 break;
					 }
				 }
				 
			 }
		}
		
		/*if (ar.size() != this.capacity) {
			for (int i = ar.size(); i >= 0; i--) {
				if (score > ar.get(i).getScore()) {
					index = i;
				}else if (score == ar.get(i).getScore()) {
					index = i+1;
				}
			}
			ar.add(index, p);
			ar.remove(ar.size()-1);
		}else if (ar.size() != 0) {
			for
		}
		ar.add(p);
		*/
	}
	
	
	public String getName (int i) throws NullPointerException{
		return ar[i].getName();
	}
	
	public int getScore (int i) throws NullPointerException{
		return ar[i].getScore();
	}
	
	public void write (File file) throws FileNotFoundException {
		PrintStream file2 = new PrintStream (file);
		
		file2.println(this.capacity);
		
	}
	
	
}
