/*
 * Christiana Wu
 * 20767703
 * intput the numbers in the array and the legth of array(s)
 * output the average(s)
 */
package msci121;

import java.util.Arrays;
import java.util.Scanner;

public class Averages {

	public static void main(String[] args) {
		int size;
		double num; 
		double[] ar, ar2, ar3;
		Scanner input = new Scanner (System.in);
		
		System.out.print("How many numbers?: ");
		size = input.nextInt();
		
		ar = new double[size];
		
		for (int i = 0; i<size; i++) {
			System.out.print("Enter the next number: ");
			num = input.nextInt();
			
			ar[i] = num;
		}
		
		System.out.print("How many numbers?: ");
		size = input.nextInt();
		
		ar2 = new double[size];
		
		for (int i = 0; i<size; i++) {
			System.out.print("Enter the next number: ");
			num = input.nextInt();
			
			ar2[i] = num;
		}
		
		System.out.print("How many numbers?: ");
		size = input.nextInt();
		
		ar3 = new double[size];
		
		for (int i = 0; i<size; i++) {
			System.out.print("Enter the next number: ");
			num = input.nextInt();
			
			ar3[i] = num;
		}
		System.out.println("Average of these arrays " + Arrays.toString(ar) + " " + Arrays.toString(ar2)+ "  " + Arrays.toString(ar3)+ " is " + Arrays.toString(arrayAvgFor3(ar,ar2,ar3)));
		
		/*double avg = arrayAvg(ar);
		if (avg == 0 ) {
			System.out.println("This array is empty.");
		}else{
			System.out.println("Average of " + Arrays.toString(ar) + " is " + avg);
		}
		*/
	}
	
	public static double arrayAvg (double [] ar) {
		boolean isEmpty = true;
		double avg = 0.0 , sum = 0;
		for (int i = 0; i<ar.length; i++) {
			if (ar[i] != 0.0) {
				isEmpty = false;
				break;
			}else if (ar[ar.length-1] == 0.0) {	
				return avg;
			}
		}
		for(int i = 0; i<ar.length; i++) {
			sum += ar[i];
		}
		
		avg = sum/ar.length;
		
		return avg;
	}
	
	public static double[] arrayAvgFor3 (double [] ar1, double [] ar2, double [] ar3){
		double [] avgs= new double [3];
		double sum = 0, av1, av2, av3;
		for (int i = 0; i<ar1.length; i++) {
			sum += ar1[i];
		}
		avgs[0] = sum/ar1.length;
		
		sum = 0; 
		
		for (int i = 0; i<ar2.length; i++) {
			sum += ar2[i];
		}
		avgs[1] = sum/ar2.length;
		
		sum = 0;
		
		for (int i = 0; i<ar3.length; i++) {
			sum += ar3[i];
		}
		avgs[2] = sum/ar3.length;
		
		return avgs;
	}

}
