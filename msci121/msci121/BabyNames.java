/*
 * Christiana Wu 
 * 20767703 
 * Assignment 7 Problem 2 
 * Input Name Output the ranks in each decade and graph 
 * Reads a file of names and the popularity in that decade. Ask the user to see for a name to chack
 * if it is in the file and then it would print if it was use or not if it was what was the ranking in that year 
 * then it would draw a graph out for that name 
 */
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
	
	public void settings() {
		size(550,560);
		//findName (name);
	}
	
	public void findName(String name) throws FileNotFoundException {
		String fileName = null, token;
		Scanner file = new Scanner (new File (FILE)); // Scanner object scanning the file 
		while (file.hasNextLine()) { // This is scanning the file line by line 
			fileName = file.next(); // getting the first token 
			if (name.equalsIgnoreCase(fileName)) { // Checking if the name is in the file 
				System.out.println("Populatrity ranking of name: \"" + name + "\"");
				int x = 0;
				for (int i = 0; i<=DECADES-1; i++) {
					token = file.next();
					System.out.println(STARTYEAR+i*10 + " : " + token);
					textYear(STARTYEAR+i*10, x, name);
					bars (STARTYEAR+i*10, x, token);
					x+= WIDTH;
				}
				break;
			}
			if(name != fileName && !file.hasNextLine()) {
				System.out.println("\"" + name + "\" not found") ;
			}
		}
		
	}
	
	public void setup() throws FileNotFoundException {
		String name;
		Scanner input = new Scanner (System.in);
		System.out.print("Type a name: ");
		name = input.nextLine();
		
		background(255);
		stroke (204);
		for (int i = 0; i<=530; i+=WIDTH) {
			line (0, i+30, width, i+30); //horizontal
			line (i, 0, i, height);// vertical
		}
		fill(255,255,0);
		rect (0,0,height,30);
		rect (0, 530,height,30);
		findName (name);
	}
	
	public void textYear(int year, int x, String name) {
		int y = 546;
		String title = "Ranking of name " + name;
		fill(0);
		text (Integer.toString(year), x, y);
		text (title, 0, 14);
	}
	
	public void bars (int year, int x, String token) {
		int y, recHeight;
		if (Integer.parseInt(token) == 0) {
			y= height -30;
			recHeight = 0;
		}else {
			y= 30 +Integer.parseInt(token)/2;
			recHeight = (height - 60) - Integer.parseInt(token)/2;
		}
		fill(255,0,0);
		rect(x, y, 30, recHeight);
		fill (0);
		text (token, x, y);
	}
	
}
