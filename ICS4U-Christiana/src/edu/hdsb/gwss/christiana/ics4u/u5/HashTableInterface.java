package edu.hdsb.gwss.christiana.ics4u.u5;

/**
 * Lesson: 6.04 - (Closed) Hash Table
 */
public interface HashTableInterface {


    /**
     * @return Returns the number of keys in this hashtable.
     */
    public int size();
    
    /**
     * @return Returns the capacity of this hash table.
     */
    public int capacity();
    
    /**
     * @return The load factor of the hashtable.
     */
    public double loadFactor();
    
    /**
     * Clears this hashtable so that it contains no keys.
     */
    public void makeEmpty();
    
    /**
     * Tests if this hashtable maps no keys to values.
     */
    public boolean isEmpty();
    
    /**
     * Increases the capacity of and internally reorganizes this hashtable, in 
     * order to accommodate and access its entries more efficiently.
     */
    public void rehash();
    
    /**
     * Returns the value to which the specified key is mapped, or null if this 
     * map contains no mapping for the key.
     * @param key
     * @return
     */
    public Student get( int key );
    
    /**
     * Get it from the hash table 
     * @param key
     * @param value
     */
    public void put( int key, Student value);
    
    /**
     * place it into the hash table 
     * @param value
     * @return
     */
    public boolean contains( Student value );
    
    /**
     *
     * @param key
     * @return
     */
    public boolean containsKey( int key );
    
    /**
     *
     * @param key
     * @return
     */
    public int hash( int key );
    /**
     * this creates the the hash code from the key 
     */

}
