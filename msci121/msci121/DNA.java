package msci121;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DNA {
	public static final int MIN = 5;
	public static final double PERCENT = 30;
	public static final int UNIQUE = 4;
	public static final int SIZECODON = 3;
	
	public static void main (String arg[]) throws FileNotFoundException {
		Scanner input = new Scanner (new File("dna.txt"));
		print(input);
	}
	
	public static void print (Scanner input) throws FileNotFoundException {		
		String nuc;
		int nucLength;
		while (input.hasNext()) {
			System.out.println("Region Name: " + input.nextLine());
			nuc = input.nextLine().toUpperCase();
			int [] amount = count(nuc);
			nucLength = nuc.length();
			double[] mass = mass(nucLength, amount);
			System.out.println("Nucleoides: " + nuc);
			System.out.println("Nuc. Counts: " + Arrays.toString(amount));
			
		}
	}
	
	public static int[] count (String nuc) {
		/*
		 * a = element 0
		 * c = element 1
		 * g = element 2
		 * t = element 3
		 */
		int[] amount = new int [UNIQUE];
		for (int i = 0; i< nuc.length(); i++) {
			if (nuc.charAt(i) == 'A') {
				amount[0]++;
			}else if (nuc.charAt(i) == 'C') {
				amount[1]++;
			}else if (nuc.charAt(i) == 'G') {
				amount[2]++;
			}else if (nuc.charAt(i) == 'T') {
				amount[3]++;
			}
		}
		return amount;
	}
	
	public static double[] mass (int length, int[] counts) {
		/*
		 * a = element 0
		 * c = element 1
		 * g = element 2
		 * t = element 3
		 */
		double totMass=0, totNuc = 0, junkNumb;
		double[] masses = {135.128, 111.103, 151.128, 125.107, 100.000};
		double [] massPerc = new double[UNIQUE];
		
		for (int i = 0; i<=counts.length; i++) {
			
		}

		
		return masses;
	}

}
