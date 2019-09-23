
public class ArrayMethods {
	public static int[] append (int[] a1, int[] a2) {
		int[] a3;
		int length1 = a1.length;
		int length2 = a2.length;
		
		a3 = new int[length1 + length2];
		
		for(int i=0; i<length1; i++) {
			a3[i] = a1[i];
		}
		
		for(int i=0; i<length2; i++) {
			a3[i+length1] = a2[i];
		}
		
		return a3; 
	}
}
