
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HeapIntPriorityQueue {
    private ArrayList<Integer> elements;

    public HeapIntPriorityQueue() {
        elements = new ArrayList<Integer>();
        elements.add(-1); // dummy 0th element
    }

    // Adds the given value to this priority queue in order.
    public void add(int value) {
        elements.add(value); // add as rightmost leaf

        // "swim up" as necessary to fix ordering
        int i = elements.size() - 1;
        while (hasParent(i) && elements.get(i) < elements.get(parent(i))) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // TODO: add remove method
    public int remove() {
    	if (elements.isEmpty()) {
    		throw new NoSuchElementException();
    	}
    	int i = 1; 
    	int removed = elements.remove(1);
    	elements.add(1, elements.remove(elements.size()-1));
    	while (hasLeftChild(i) && elements.get(i)>elements.get(leftChild(i)) ) {
    		swap(i,leftChild(i));
    		i = leftChild(i);
    	}
    	return removed;
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return index * 2;
    }

    private int rightChild(int index) {
        return index * 2 + 1;
    }

    private boolean hasParent(int index) {
        return index > 1;
    }

    private boolean hasLeftChild(int index) {
        return leftChild(index) < elements.size();
    }

    private boolean hasRightChild(int index) {
        return rightChild(index) < elements.size();
    }

    private void swap(int index1, int index2) {
        int temp = elements.get(index1);
        elements.set(index1, elements.get(index2));
        elements.set(index2, temp);
    }
}
