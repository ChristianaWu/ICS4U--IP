

import java.util.Scanner;

public class BillCalcualtor {
	String name;
	double cost;

	public static void printHighestCost(Scanner input) {
		int numbPeople = input.nextInt();
		double high = 0;
		String highName = null;
		
		BillCalcualtor[] ar = new BillCalcualtor[numbPeople];
		for (int i = 0; i < ar.length - 1; i++) {
			ar[i].name = input.next();
			ar[i].cost = input.nextDouble();	
		}
		for (int i = 0; i < ar.length - 1; i++) {
			if (ar[i].cost > high) {
				high = ar[i].cost;
				highName = ar[i].name;
			}
		}
		
		System.out.println(highName + " has the highest amount at $" + high);
		
	}

}
