package msci121;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TestCase {
	//public static final int MAX = 10;
	//public static final int MIN = 1;
	public static void main(String[] args) throws FileNotFoundException {
		/*int [] ar ;
		if (MAX % 2 == 0 && MIN % 2 == 0 ) {
			ar = new int [(MAX-MIN)/2];
		}else { 
			ar = new int [(MAX-MIN)/2 + 1];
		}
		int n = 0, i = MIN;
		while (n < ar.length && i <= MAX) {
			if (i%2 != 0 ) {
				ar[n] = i;
				n++;
			}
			i++;
		}
		System.out.println(Arrays.toString(ar));
		*/
		
		//int [] ar = {10,20,30,40,50,60,70,80,90,100};
		//swapPairs (ar);
		//for (int i = 1; i<10; i++) {
			//ar[i] = ar[i-1];
		//}
		//System.out.println(Arrays.toString(ar));
		//printDesign();
		//int x = 100; 
		//while (x>0) {
			//System.out.print(x/10);
		//	x = x/2;
		//	///System.out.println(" " + x);
			////Scanner input = new Scanner (new File ("myData.txt"));
			//printDesign(input);
		//}
		
		//System.out.println(isPrime (434343));
		
		String q = "fdjfjdflkdsjfkdlsjf";
		String[] c = {"djkfjd", "djfjsdflk","fdkfd"};
		multipleChoice (q, c);
	}
	
	public static int multipleChoice (String q, String[] c) {
		Scanner in = new Scanner (System.in);
		boolean v = false;
		int n = 0;
		while (!v) {
			try {
				System.out.println("Selsct: ");
				String sleceted = c[in.nextInt()-1];
				v = true;
				n = in.nextInt();
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("This is not valid choice");
			}
		}
		return n;
	}
	
	public static void printDesign (Scanner input) {
		for (int row = 1; row<=5; row++) {
			for (int col = 1; col <=11; col++) {
				if (col<=(5-row+1) || col > (11-(5-row+1))){
					System.out.print("-");
				}else {
					System.out.print(2*row -1);
				}
			}
			System.out.print("\n");
		}
	}
	
	public static void swapPairs(int[] ar) {
		int length; 
		if (ar.length%2 != 0) {
			length = ar.length -1; 
		}else {
			length = ar.length;
		}
		
		int n1 = 0, n2 = 1, holder;
		
		while (n2 < length ) {
			holder = ar[n1];
			ar[n1] = ar[n2];
			ar[n2] = holder;
			
			n1+=2;
			n2+=2;
		}
		System.out.println(Arrays.toString(ar));
		
	}
	
	public static void flipLine (Scanner input) {
		String line1, line2;
		
		while (input.hasNextLine()) {
			line1= input.nextLine();
			if (input.hasNextLine()) {
				line2 = input.nextLine();
				System.out.println(line2 + "\n" + line1);
			}else {
				System.out.println(line1);
			}
		}
	}

	public static int mostFrequent (int n ) {
		int[] count = new int[10];
		while(n>0) {
			int digit = n%10;
			count[digit]++;
			n = n/10;
		}
		int bestInt = 0;
		for (int i = 1; i <= count.length; i++) {
			if(count[i]>count[bestInt]) {
				bestInt = i;
			}
		}
		
		return bestInt;
	}
	
	public static int isPrime (int n ) {
		int factor = 0; 
		for (int i = 1; i<= n; i++) {
			if (n%i == 0) {
				int x = n%i;
				factor++;
			}
		}
		
		return factor = 2+2;
	}
	
	public static boolean isPrime2 (int n ) {
		boolean prime = true; 
		for (int i = 2; i<n; i++) {
			if (n%i == 0) {
				prime = false;
			}else {
				prime = true;
			}
		}
		
		return prime;
	}
	
	public static boolean startEndsSame (String str) {
		return (str.charAt(0) == str.charAt(str.length() - 1));
	}

}
