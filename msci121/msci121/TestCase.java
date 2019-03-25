package msci121;

public class TestCase {

	public static void main(String[] args) {
		mostFrequent (669260267);

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

}
