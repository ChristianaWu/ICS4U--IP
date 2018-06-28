package edu.hdsb.gwss.ics4u.pt;

import edu.hdsb.gwss.christiana.ics4u.u5.Node;

/**
 * Linked List of Students
 *
 * @version v2018.S2
 */
public class LinkedListPT {

    private NodePT head;
    private NodePT tail;

    /**
     * Constructor: Empty Linked List
     */
    public LinkedListPT() {
        this.head = null;
        this.tail = null;
    }

    /**
     * @return returns the size (# of students) in the linked list.
     */
    public int size() {
        if (this.isEmpty()) {
            return 0;
        }
        int i = 1;
        NodePT n = this.head;
        while( n.getNext() != null ) {
            i++;
            n = n.getNext();
        }
        return i;
    }

    /**
     * This method makes the linked list empty.
     */
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    /**
     * This method returns true if the linked list is empty
     *
     * @return returns true if there are no student objects in the linked list
     */
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    /**
     * This method adds a student object to the end of the linked list.
     *
     * @param student
     */
    public void addAtEnd( CSStudent student ) {
        if (this.isEmpty()) {
            NodePT n = new NodePT(student);
            this.head = n;
            this.tail = n;
        } else {
            NodePT n = new NodePT(student);
            this.tail.setNext(n);
            this.tail = n;
        }
    }

    /**
     * This method will get a student object from the linked list, given the
     * student number
     *
     * @param key student number (key)
     * @return returns the student object for the given key, or null if it
     * doesn't exist.
     */
    public CSStudent get( int key ) {
        NodePT pointer = this.head;
        int counter = 0;
        if (this.isEmpty()) return null;
        while (pointer.getData().getKey() != key) {
            if (counter >= this.size() - 1) {
                return null;
            } else {
                pointer = pointer.getNext();
                counter++;
            }
        }
        return pointer.getData();
    }
    
    /**
     * This method will remove a student object from the linked list, given the
     * student number.
     *
     * @param key student number (key)
     * @return returns the removed student object, or null if the key is not found
     */
    public CSStudent remove( int key ) {
        NodePT n = this.head;
        if (!(key == -1 || isEmpty())) {

            if (size() == 1 && this.head.getData().getKey() == key) {
                makeEmpty();
            } else if (this.head.getData().getKey() == key) {
                CSStudent headValue = this.head.getData();
                NodePT front = this.head;
                this.head = front.getNext();
                front.setNext(null);
                return headValue;
            } else if (this.tail.getData().getKey() == key) {
                NodePT head = this.head;
                while (head.getNext().getNext() != null) {
                    head = head.getNext();
                }
                CSStudent tailVaule = this.tail.getData();
                this.tail = head;
                this.tail.setNext(null);
                return tailVaule;
            } else {
                while (n.getNext().getData().getKey() != key) {
                    n = n.getNext();
                }
                CSStudent removed = n.getNext().getData();
                NodePT toDelete = n.getNext();
                n.setNext(toDelete.getNext());
                toDelete.setNext(null);
                return removed;
            }

        }
        return null;
    }

    /**
     * DONE FOR YOU
     */
    @Override
    public String toString() {
        return "HEAD: " + toString( this.head );
    }

    /**
     * DONE FOR YOU
     */
    private String toString( NodePT n ) {
        String s = "";
        if ( n != null ) {
            s = n.getData() + " --> " + this.toString( n.getNext() );
        }
        return s;
    }

}
