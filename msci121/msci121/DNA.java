package msci121;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class DNA {
	public static final int MIN = 5;
	public static final double PERCENT = 30.0;
	public static final int UNIQUE = 4;
	public static final int SIZECODON = 3;
	public static final double[] MASSES = {135.128, 111.103, 151.128, 125.107, 100.000};
	
	public static void main (String arg[]) throws FileNotFoundException {
		String inFile, outFile; 
		Scanner input = new Scanner (System.in);
		
		System.out.print("Input File Name: ");
		inFile = input.nextLine();
		System.out.print("Output File Name: ");
		outFile = input.nextLine();
		
		PrintStream file = new PrintStream (new File (outFile));
		Scanner fileIn = new Scanner (new File(inFile));
		print(fileIn, file);
	}
	
	public static void print (Scanner input, PrintStream file) throws FileNotFoundException {		
		String nuc;
		while (input.hasNext()) {// check if there are still lines to read 
			file.println("Region Name: " + input.nextLine()); //Reading the region 
			
			nuc = input.nextLine().toUpperCase(); //Making the DNA cap
			
			int [] amount = count(nuc); 
			String [] codons = codons(nuc);
			double [] masses = mass(amount);
			file.println("Nucleoides: " + nuc);
			file.println("Nuc. Counts: " + Arrays.toString(Arrays.copyOf(amount,4)));
			file.println("Total Mass%: " + Arrays.toString(Arrays.copyOf(masses,4)) + " of " + masses[masses.length-1]);
			file.println("Codon: " + Arrays.toString(codons));
			
			//Checking to see if it is a protein
			boolean isProtein = isProtein(codons, amount);
			if (isProtein) {
				file.println("Is Protein?: Yes\n");
			}else {
				file.println("Is Protein?: No\n");
			}
		}
	}
	
	//Counts how many nucleotides in the DNA strand 
	public static int[] count (String nuc) {
		/*
		 * a = element 0
		 * c = element 1
		 * g = element 2
		 * t = element 3
		 */
		int[] amount = new int [UNIQUE+1];
		for (int i = 0; i< nuc.length(); i++) {
			if (nuc.charAt(i) == 'A') {
				amount[0]++;
			}else if (nuc.charAt(i) == 'C') {
				amount[1]++;
			}else if (nuc.charAt(i) == 'G') {
				amount[2]++;
			}else if (nuc.charAt(i) == 'T') {
				amount[3]++;
			}else if (nuc.charAt(i) == '-') {//this is the junk so will not be printed bt used to find mass
				amount[4]++;
			}
		}
		return amount;
	}
	
	//Find the total mass and the mass%
	public static double[] mass (int[] counts) {
		/*
		 * a = element 0
		 * c = element 1
		 * g = element 2
		 * t = element 3
		 */
		double totMass=0;
		double [] massPerc = new double[UNIQUE+1];
		double num;
		
		//This is to find the total mass and placing the mass of each nucleotides in the mass% array
		for (int i = 0; i<=counts.length-1; i++) {
			massPerc[i] = MASSES[i] * counts[i];
			totMass += massPerc[i];
		}
		
		//Place the total mass in the last element
		massPerc[massPerc.length-1] = Math.round(totMass* 10.0)/10.0;
		
		//Finding hte mass percent for each of the nucleotide
		for (int i = 0; i< massPerc.length-1; i++) {
			num = massPerc[i]/totMass * 100;
			massPerc[i] = Math.round(num * 10.0)/10.0;
		}
		
		return massPerc;
	}
	
	//Creating the codons 
	public static String[] codons (String nuc) {
		String newSr =  nuc.replace("-", "");//eliminate junk
		String[] codons = new String [newSr.length()/SIZECODON]; //setting the size bases on the side of the new string length
		int i = 0;
		while (i < codons.length) {
		    codons[i] = newSr.substring(i*SIZECODON, (i+1)*SIZECODON); // Placing codons in the array 
		    i ++;
		}
		
		return codons;
	}
	
	//Checking for if it is a protein
	public static boolean isProtein (String[] codons, int[] counts) {
		double cdPerc, sum = 0;
		
		//See if C G nucleotides are 30% of the DNA
		for (int i = 0; i < counts.length; i++) {
			sum += counts[i];
		}
		
		cdPerc = (counts[1]+counts[2])/sum * 100.0;
		
		
		//Doing the check 
		if (cdPerc >= PERCENT && codons.length >= MIN && codons[0].equalsIgnoreCase("ATG") && (codons[codons.length-1].equalsIgnoreCase("TAA") || codons[codons.length-1].equalsIgnoreCase("TAG")|| codons[codons.length-1].equalsIgnoreCase("TGA"))) {
			return true;
		}
		
		return false;
		
	}

}
