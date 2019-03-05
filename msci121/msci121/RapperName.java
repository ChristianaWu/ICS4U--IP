/*
 * Christiana Wu 
 * 20767703 
 * Tut 5 
 * Input name output rapper name 
 */
package msci121;

import java.util.Scanner;

public class RapperName {

	public static void main(String[] args) {
		// Vairable 
		String name; 
		
		//Object 
		Scanner input = new Scanner (System.in);
		
		System.out.print("Type in your name homie: ");
		name = input.nextLine();
		rapperName (name);
		
		input.close();
	}
	
	public static void rapperName (String name) {
		String initials;
		
		for (int i = 1; i <= name.length(); i++) {
			if (name.charAt(i) == ' ' && name.charAt(i+1) != ' ') {
				initials = Character.toString(name.charAt(i+1)).toUpperCase(); // Get last name char 
				System.out.println("Your rapper name is 'Lil' " + Character.toString(name.charAt(0)).toUpperCase() + "." + initials + " , aka A$Ap " + name.substring(0,2).toUpperCase() );
				break; // get out of loop 
			}
			
		}
		
		
		
		
		
	}
	
	

}
