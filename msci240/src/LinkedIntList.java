/*
 * Christiana
 * HW 2 
 * 2019-10-10
 * This is an object class that use the LinkedNOde class ans creates Linked list
 * The methods that are in this are use when an LinkedIntList object is create 
 * There are not one input for the program to run, but some of the methods need an in to be pass
 * when the object is created and that method it called 
 * The out put is usually a modified LnkedIntList
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements Iterable<Integer> {
    // DO NOT ALTER THE FIELDS IN ANY WAY
    private ListNode front;

    // Constructs a new empty list.
    // DO NOT ALTER THIS CONSTRUCTOR IN ANY WAY
    public LinkedIntList() {
        front = null;
    }

    // Adds the given value to the end of the list.
    // DO NOT ALTER THIS METHOD IN ANY WAY
    public void add(int value) {
        if (front == null) {
            // adding to an empty list
            front = new ListNode(value);
        } else {
            // adding to the end of an existing list;
            // traverse to the last node in the list so we can append to it
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }

            // at this point, current.next == null,
            // and current refers to the last node
            current.next = new ListNode(value);
        }
    }

    // Returns a String representation of this LinkedIntList
    // DO NOT ALTER THIS METHOD IN ANY WAY
    @Override
    public String toString() {
        String str = "front ";
        ListNode current = front;
        while (current != null) {
            str += "-> [" + current.data + "] ";
            current = current.next;
        }
        str += "/";
        return str;
    }

    // Returns an iterator (to use foreach loop)
    // DO NOT ALTER THIS METHOD IN ANY WAY
    @Override
    public Iterator<Integer> iterator() {
        return new LinkedIterator();
    }

    // Class for iterating over LinkedIntList
    // DO NOT ALTER THIS INNER CLASS IN ANY WAY
    private class LinkedIterator implements Iterator<Integer> {
        private ListNode current;

        public LinkedIterator() {
            current = front;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            int data = current.data;
            current = current.next;
            return data;
        }

    }

    // TODO: add your split method here
    public int min () {
    	if (this.front == null) {
    		throw new NoSuchElementException();
    	}
    	
    	ListNode current = this.front;
    	int min = current.data;
    	while (current != null) {
    		if (current.data < min) {
    			min = current.data;
    		}
    		current = current.next;
    	}
    	return min;
    }
    
    public int countDuplicates () {
    	int dup = 0;
    	if (this.front == null) {
    		return dup;
    	}
    	
    	int numbUnderCheck = this.front.data;
    	ListNode current = this.front.next;
    	while (current != null) {
    		if (current.data == numbUnderCheck) {
    			dup++;
    		}else {
    			numbUnderCheck = current.data;
    		}
    		current = current.next;
    	}
    	return dup;
    }
    
    public void compress(int x) {
    	ListNode current = this.front.next, temp = this.front;
    	int i = 1;
    	if (this.front == null) {
    		return;
    	}
    	
    	while (current != null) {
    		if(i != x) {
    			temp.data = temp.data + current.data;
    			current =current.next;
    			i++;
    		}else {
    			temp.next = current;
    			temp = temp.next;
    			current = current.next;
    			i = 1;
    		}
    		if (current == null) {
    			temp.next = null;
    		}
    	}
    			    
    }
    
    public void removeRange (int i1, int i2) {
    	ListNode start = this.front;
    	ListNode end = this.front;
    	
    	if (i1 < 0 || i2 < 0 ) {
    		throw new IllegalArgumentException();
    	}
  
    	for (int i = 0; i < i2+1; i++) {
    		end = end.next;
    	}
    	
    	if (i1 != 0) {
    		for (int i = 0; i < i1-1; i++) {
	    		start = start.next;
	    	}
    		start.next = end;
    	}else if (i1 == 0){
    		this.front = end;
    	}
	    	
    	
    }
    
//    public void split () {
//    	ListNode neg = null;
//    	ListNode current = this.front;
//    	while (current != null) {
//    		if (current.next == null && current.data <0) {
//    			neg = current;
//    			current = null;
//    			neg.next = this.front;
//    			this.front = neg;
//    			break;
//    		} else if (current.next.data < 0) {
//    			neg = current.next;
//    			current.next= neg.next;
//    			neg.next = this.front;
//    			this.front = neg;
//    			neg = neg.next;
//    		}
//    		current = current.next;
//    	}    	

    	//this.front = neg;
//    }
}
