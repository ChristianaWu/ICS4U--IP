import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] a1 = {4,15,7};
     	int[] a2 = a1;
     	a2[0] = 7;
     	System.out.println(Arrays.toString(a1));

	}

}
