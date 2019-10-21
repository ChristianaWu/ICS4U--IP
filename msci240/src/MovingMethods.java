

public class MovingMethods {
    public static void moveMinToFrontA(int[] a) {
        int minIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }

        for (int i = minIndex; i > 0; i--) {
            swap(a, i, i - 1);
        }
    }

    public static void moveMinToFrontB(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = 0;
            for (int j = 0; j < i; j++) {
                if (a[i] < a[minIndex]) {
                    minIndex = i;
                }
            }

            for (int j = minIndex; j > 0; j--) {
                swap(a, j, j - 1);
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
