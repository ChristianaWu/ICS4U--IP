package edu.hdsb.gwss.ics4u.pt;

import edu.hdsb.gwss.christiana.ics4u.u5.Student;

/**
 * Open Hash Table
 * 
 * @version v2018.S2
 */
public class OpenHashTable {

    /**
     * Open Hash Table: an array of Linked Lists
     */
    private LinkedListPT[] data;
    private int sizeCounter = 0;

    /**
     * Creates an Open Hash Table; default size 11
     */
    public OpenHashTable() {
        this( 11 );
    }

    /**
     * Creates an Open Hash Table
     *
     * @param intialSize the initial capacity, rounded to the next prime.
     */
    public OpenHashTable( int intialSize ) {
        this.data = new LinkedListPT[nextPrime( intialSize )];
        makeEmpty();
    }

    /**
     * Make that hash table empty.
     */
    public void makeEmpty() {
        this.sizeCounter = 0;
        for(int i=0; i<this.capacity(); i++){
            LinkedListPT l = new LinkedListPT();
            data[i] = l;
        }    
        
        
    }

    /**
     * This method returns true if there are no student objects in the hash
     * table.
     *
     * @return true if the hash table contains no student objects.
     */
    public boolean isEmpty() {
        if (this.sizeCounter == 0)return true;
        return false;
    }

    /**
     * Gets the student object given the key (student number). This method does
     * NOT remove the object.
     *
     * @param key
     * @return student object for the given key (student number)
     */
    public CSStudent get( int key ) {
        int index = this.hash(key);
        
        return data[index].get(key);
    }

    /**
     * Puts a student in the Hash Table. Duplicates are fine, and assume student
     * objects are correct and have unique keys.
     *
     * @param student valid student object
     */
    public void put( CSStudent student ) {
        int index = this.hash(student.getKey());
            
        this.data[index].addAtEnd(student);
        this.sizeCounter++;
        
    }

    /**
     * Determines if a student object exists with the given key (student number)
     *
     * @param key key (student number)
     * @return returns true if the student with the given key (student number) exists
     */
    public boolean containsKey( int key ) {
         if( this.get(key) == null ) return false;
        return true;
    }

    /**
     * The number of student objects in the hash table.
     *
     * @return the number of student objects in the hash table.
     */
    public int size() {
        return sizeCounter;
    }

    /**
     * The capacity of the Open Hash Table; THINK! THINK! THINK! TRICK?
     *
     * @return
     */
    public int capacity() {
        return this.data.length;
    }

    /**
     * COMPLETE!
     *
     * @return returns a graphic of the Open Hash Table
     */
    public String toString() {
        String s = "";
        for ( int i = 0; i < data.length; i++ ) {
            if( data[i] != null )
                s = s + "\n" + "HT[" + i + "] " + data[i].toString();
            else
                s = s + "\n" + "HT[" + i + "] EMPTY";
        }
        return s;
    }

    /**
     * Hash Function; COMPLETE
     *
     * @param key key (student number)
     * @return hash value
     */
    public int hash( int key ) {
        return key % data.length;
    }

    /**
     * COMPLETE
     */
    public static int nextPrime( int n ) {
        while ( !isPrime( n ) ) {
            n++;
        };
        return n;
    }

    /**
     * COMPLETE
     */
    private static boolean isPrime( long n ) {
        // EVEN TEST
        if ( n > 2 && ( n & 1 ) == 0 ) {
            return false;
        }
        // ODD FACTORS
        for ( int i = 3; i * i <= n; i += 2 ) {
            if ( n % i == 0 ) {
                return false;
            }
        }
        return true;
    }

}
