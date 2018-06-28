package edu.hdsb.gwss.christiana.ics4u.u5;

/**
 * Lesson: 6.03 - Linked List
 */
public interface LinkListInterface {

    public int size();
    
    public void makeEmpty();
    
    public boolean isEmpty();
    
    /**
     * Adds a node to the front of the linked list.
     *
     * @param str
     */
    public void addAtFront( String str );
    
    /**
     * Adds a node to the end of the linked list.
     *
     * @param str
     */
    public void addAtEnd( String str );
    
    /**
     * Removes the first occurrence of the given string.
     *
     * @param str
     */
    public void remove( String str );
    
    
    public String removeHead();
    public String removeTail();
    
    public String head();
    public String tail();
    
    /**
     * Creates a string that lists the nodes of the linked list.
     *
     * @return string
     */
    @Override
    public String toString( );

}
