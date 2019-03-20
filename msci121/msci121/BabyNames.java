package msci121;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import processing.core.PApplet;

public class BabyNames extends PApplet {
	public static final String FILE = "names.txt";
	public static final int STARTYEAR = 1900;
	public static final int DECADES  = 11;
	public static final int WIDTH = 50;
	public static void main(String args[]) {
		PApplet.main("msci121.BabyNames");
	}
	
	public void settings() throws FileNotFoundException {
		size(550,560);
		String name;
		Scanner input = new Scanner (System.in);
		System.out.print("Type a name: ");
		name = input.nextLine();
		findName (name);
	}
	
	public void setup() {
		background(255);
		stroke (204);
		for (int i = 30; i<=530; i+=WIDTH) {
			line (0, i, 560, i);
			line (i, 0, i, 550);
		}
		fill(255,255,0);
		rect (0,0,550,30);
		rect (0, 530,550,30);
	}
	
	public void findName(String name ) throws FileNotFoundException {
		String fileName = null;
		Scanner file = new Scanner (new File (FILE));
		while (file.hasNextLine()) {
			fileName = file.next();
			if (name.equalsIgnoreCase(fileName)) {
				System.out.println("Populatrity ranking of name: \"" + name + "\"");
				int x = 0;
				for (int i = 0; i<=DECADES-1; i++) {
					System.out.println(STARTYEAR+i*10 + " : " + file.next());
					text ()
				}
				break;
			}
			if(name != fileName && !file.hasNextLine()) {
				System.out.println("\"" + name + "\" not found") ;
			}
		}
		
	}
	
	public void text (int year, String numb) {
		int x = 0, y = 540;
		text (year, x, y);
		x+= 50;
	}
	
	public void bars () {
		
	}
	
}
