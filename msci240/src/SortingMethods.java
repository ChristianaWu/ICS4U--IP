
public class SortingMethods {
	public static int[] dualSelectionSort (int[] ar) {
		int max,min,length;
		
		for (int i = 0 ; i <ar.length/2; i++) {
			min = i;
			max = i;
			length = ar.length-1-i;
			for (int j = i+1; j <=length; j++) {
				if (ar[j] < ar[min]) {
					min = j;
				}
				if (ar[j] > ar[max]) {
					max = j;
				}
			}
			swap(ar,i,min);
			swap (ar,length, max);
		}
		
		return ar;
	}
	
	private static void swap(int [] ar, int i, int min) {
		int holder; 
		holder = ar[i];
		ar[i] = ar[min];
		ar[min] = holder;
		
	}
}
