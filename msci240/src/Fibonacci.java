
public class Fibonacci {
    public static long fib(int n) {
    	long [] ar = new long [n];
        if (n <= 2) {
            return 1;
        } else {
        	return fib(n - 1) + fib(n - 2);
        }
    }
  
    private static long fib (int n, long[] ar) {
    	if (n <= 2) {
        	ar[n-1] = 1;
            return 1;
        } else if (ar[n] != 0){
        	return ar[n-1];
        }else {
        	ar[n-1] =  fib(n - 1,ar) + fib(n - 2,ar);
            return ar[n-1];
        }
    }
}