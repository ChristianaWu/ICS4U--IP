/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u5;

/**
 *
 * @author 1wuchr
 */
public class HashTableClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       HashTable t = new HashTable();
       Student s = new Student();
       // TEST #1 - EMPTY TABLE
       assert( t.size() == 0 );
       assert( t.capacity() == 53 );
       assert (t.get(132) == null );
       assert( t.containsKey(132) == false);
       assert( t.contains(s) == false );
       assert( t.isEmpty() );
       assert (t.size() == 0);
       assert (t.loadFactor() == 0);
       
       HashTable t2 = new HashTable(4);
       //TEST #2a - Test capsicty to change to prime number 
       assert( t2.capacity() == 5 );

       //TEST #2b - Test puching
       Student s2 = new Student("a", "A", 53, 1103);
       Student s3 = new Student("b", "B", 2213, 1347);
       Student s4 = new Student("c", "C", 3313, 1343);
       t2.put(s2.hashCode(), s2);
       t2.put(s3.hashCode(), s3);
       t2.put(s4.hashCode(), s4);
       assert( t2.size() == 3 );
       assert (t2.loadFactor() == 0.6);
       assert (t2.get(s3.hashCode()).equals(s3) );
       assert( t2.containsKey(s3.hashCode()) == true);
       assert( t2.contains(s3) == true );
       assert( !t2.isEmpty() );
       
       //TEST #2c - Test load factor over 0.75
       Student s5 = new Student("d", "D", 4321, 12347);
       Student s6 = new Student("e", "E", 4567, 2347);
       t2.put(s5.hashCode(), s5);
       t2.put(s6.hashCode(), s6);
       assert (t2.loadFactor() == (double) 5/t2.capacity());
       assert (t2.size() == 5);
       assert (t2.capacity() == 17);
       
       //TEST #2d - Test puting identical object in 
       Student s7 = new Student("d", "D", 4321, 12347);
       assert (t2.size() == 5);
       
       //TEST #3 - Make empty
       t2.makeEmpty();
       assert (t2.size() == 0);
       assert (t.get(s6.hashCode()) == null );
       assert( t.containsKey(s6.hashCode()) == false);
       assert( t.contains(s) == false );
       assert( t.isEmpty() );
       
        
    }
    
}
