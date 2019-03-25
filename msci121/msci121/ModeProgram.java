package msci121;

import java.util.Arrays;
import java.util.Scanner;

public class ModeProgram {

	public static void main(String[] args) {
		int size, num; 
		int[] ar;
		Scanner input = new Scanner (System.in);
		
		System.out.print("How many numbers?: ");
		size = input.nextInt();
		
		ar = new int[size];
		
		for (int i = 0; i<size; i++) {
			System.out.print("Enter the next number: ");
			num = input.nextInt();
			
			ar[i] = num;
		}
		
		int mode = mode(ar);
		
		System.out.println("The mode of " + Arrays.toString(ar) + " is " + mode);
		
	}
	
	public static int mode (int[] ar) {
		int[] count = new int[100];
		for (int i = 0; i <=ar.length - 1; i++) {
			count[ar[i]]++;
		}
		int best = 0;
		for (int i = 1; i <= count.length-1; i++) {
			if (count[i] > count[best]) {
				best = i;
			}
		}
		
		return best;
	}

}
