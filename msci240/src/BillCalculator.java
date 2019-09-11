

import java.util.Scanner;

public class BillCalculator {
	String name;
	double cost;

	public static void printHighestCost(Scanner input) {
		int numbPeople = input.nextInt();
		double high = 0;
		String highName = null;
		
		BillCalculator[] ar = new BillCalculator[numbPeople];
		for (int i = 0; i < ar.length - 1; i++) {
			ar[i] = new BillCalculator();
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
