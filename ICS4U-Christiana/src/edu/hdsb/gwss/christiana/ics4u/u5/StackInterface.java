package edu.hdsb.gwss.christiana.ics4u.u5;

/**
 * Stack Interface.
 *
 * @author Wm.Muir
 * @version 2017-18.S2
 */
public interface StackInterface {

    public int top();

    public int pop();

    public void push( int value );

    public int size();
    
    public int capacity();

    public boolean isEmpty();
    
    public boolean isFull();

    public void makeEmpty();

}
