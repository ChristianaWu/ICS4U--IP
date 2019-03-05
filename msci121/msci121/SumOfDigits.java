package msci121;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		//Objects 
		Scanner input = new Scanner (System.in);
				
		// Variables 
		String number;
		int sum;
				
		System.out.print("Type a number in: ");
		number = input.nextLine();
		sum = digitSum (number);
				
		System.out.println("The sum of the digits is " + sum);
				
		input.close();
	}
	public static int digitSum (String numb) {
		int sum = 0; 
		int index = 0, dig;
				
		while (index <= numb.length()-1) {
			dig = Character.getNumericValue(numb.charAt(index));
			sum = sum + dig; 
			index++;
		}

		return sum;
	}

}
