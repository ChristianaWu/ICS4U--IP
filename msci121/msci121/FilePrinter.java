/*
 * Christiana Wu
 * 20767703 
 * Input file name 
 */
package msci121;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilePrinter {

	public static void main(String[] args) throws FileNotFoundException{
		//String file = "myData.txt";
		String file; 
		Scanner input = new Scanner (System.in);
		System.out.print("What is your file name: ");
		file = input.nextLine();
		printEntireFile (file + ".txt");

	}
	public static void printEntireFile (String file) throws FileNotFoundException {
		File doc = new File (file);
		Scanner input = new Scanner (doc);
		while (input.hasNextLine()) {
			while (input.hasNext()) {
				String text = input.next();
				System.out.print(text + " ");
			}
			System.out.println();
		}
			
	}


}
