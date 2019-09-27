import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class HighScoreTable {
	private int capacity;
	private int size = 0;
	private Player [] ar;
	
	public HighScoreTable () {
		this.capacity = 10;
		this.ar = new Player [10];
	}
	
	public HighScoreTable (int capacity){
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
	
	public void add (String name, int score){
		Player p = new Player (name,score);
		ArrayList<Player> list= new ArrayList<>();
		Player holder, temp;
		int i = 0;

		if (this.size == 0 ) {
			this.ar[0] = p;
			this.size++;
		}else if (score < this.ar[size - 1 ].getPlayerScore() && size == this.capacity){
			return;
		}else {
			while(i < this.size) {
				if (score >=this.ar[i].getPlayerScore()) {
					break;
				}
				i++;
			}
			
			try {
				if (score > this.ar[i].getPlayerScore()) {
					this.ar = moveAndAdd (this.ar, i, p, this.size);
				}else if (score == this.ar[i].getPlayerScore()) {
					this.ar = moveAndAdd (this.ar, i+1, p, this.size);
				}
				
				if (this.size != this.capacity) {
					this.size++;
				}
			}catch (NullPointerException e) {
				this.ar[this.size] = p;
				this.size++;
			}
			
		}
		
	}
	
	private static Player[] moveAndAdd (Player[] ar, int i, Player p, int size) {
		Player holder,temp;//;
		
		holder = ar[i];
		ar[i] = p;
		if (size < ar.length) {
			size++;
		}

		for (int z = i+1; z <size; z++) {
			temp = ar[z];
			ar[z] = holder;
			holder = temp;
			
		}
	
		return ar;
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
		file2.println(this.size);

		for (int i = 0; i < this.size; i ++) {
			file2.println(this.ar[i].toString());
		}
		
	}
	
	public static HighScoreTable read (File file) throws FileNotFoundException{
		HighScoreTable x;
		Scanner fileIn = new Scanner (file);
		String line;
		
		if (!fileIn.hasNextLine()) {
			x = new HighScoreTable ();
		}else {
			int capacity = fileIn.nextInt();
			x = new HighScoreTable (capacity);
			int size = fileIn.nextInt();
			fileIn.nextLine();
			while (fileIn.hasNextLine()) {
				line = fileIn.nextLine();
				line = line.replace(",", " ");
				Scanner lineSC = new Scanner (line);
				
				//String name = lineSC.next();
				
				x.add(lineSC.next(), lineSC.nextInt());
			}
			
		}
		return x;
		
	}
	
	
}
