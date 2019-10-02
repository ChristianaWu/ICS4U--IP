

import java.util.Arrays;

public class ArrayIntList {
    private int size;
    private int[] data;

    public ArrayIntList() {
        this(2);
    }

    public ArrayIntList(int capacity) {
        size = 0;
        data = new int[capacity];
    }

    public int size() {
        return size;
    }

    public int get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[i];
    }

    public void add(int value) {
        if (size >= data.length) {
            grow(); // hide details in grow method
        }
        data[size] = value;
        size++;
    }

    private void grow() {
        // this line of code does the same thing as above, but faster
        data = Arrays.copyOf(data, data.length * 2);
    }
    
    public ArrayIntList runningTotal() {
    	ArrayIntList l = new ArrayIntList (this.size);
    	int sum;
    	
    	if (this.size != 0) {
    		sum = this.data[0];
        	l.add(sum);
    		for (int i = 1; i < this.size; i++) {
        		sum = sum + this.data[i];
        		l.add(sum);
        	}
    	}
    	
    	return l;
    }

}
