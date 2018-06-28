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
public class LinkListClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkList l = new LinkList();  
       // TEST #1 - EMPTY STACK
       assert( l.head() == null );
       assert( l.tail() == null );
       assert (l.size() == 0 );
       assert( l.removeHead() == null);
       assert( l.removeTail() == null);
       assert( l.isEmpty() );
       //l.remove("a");
       
       //TEST #2a - head and tail are equal by adding to the head
       l.addAtFront("a");
       l.addAtFront("b");
       l.addAtFront("c");
       assert( l.head().equals("c") );
       assert( l.tail().equals("a") );
       assert( l.size() == 3 );
       assert( !l.isEmpty() );
       l.remove("c");
//       assert( l.removeTail().equals("b"));
//       assert( l.removeTail().equals("c"));
//       assert( l.removeHead() == "a");
//       assert( l.isEmpty() );
      
//       ////TEST #2b - head and tail are equal by adding to the tail
//       l.addAtEnd("a");
//       assert( l.head().equals("a"));
//       assert( l.tail().equals("a") );
//       assert( l.size() == 1 );
//       assert( !l.isEmpty() );
////       assert( l.removeTail() == "a");
//       assert( l.removeHead().equals("a"));//Can also reamove from tail
//       assert( l.isEmpty() );
//       
//       //TEST #3a - add many nodes to head 
//       for (int i=0; i<=10; i++){
//           l.addAtFront(Integer.toString(i));
//       }
//       assert( l.head().equals("10") );
//       assert( l.tail().equals("0"));
//       assert( l.size() == 11 );
//       assert( !l.isEmpty() );
//       assert( l.removeTail().equals("0"));
//       assert( l.removeHead().equals("10"));
//       assert( l.size() == 9 );
//       
//       //TEST #3b - make empty
//       l.makeEmpty();
//       assert( l.head() == null );
//       assert( l.tail() == null );
//       assert (l.size() == 0 );
//       assert( l.isEmpty() );
//       
//       //TEST #4 - add many nodes to tail 
//       for (int i=0; i<=10; i++){
//           l.addAtEnd(Integer.toString(i));
//       }
//       assert( l.head().equals("0") );
//       assert( l.tail().equals("10"));
//       assert( l.size() == 11 );
//       assert( !l.isEmpty() );
//       assert( l.removeTail().equals("10"));
//       assert( l.removeHead().equals("0"));
//       assert( l.size() == 9 );
//       
//       //TEST #5a - remove node not in linked list
//       l.remove("10");
//       assert( l.head().equals("1") );
//       assert( l.tail().equals("9"));
//       assert( l.size() == 9 );
//       l.printNodes();
//       
//       //TEST #5b - remove node not in linked list
//       l.remove("5");
//       assert( l.head().equals("1") );
//       assert( l.tail().equals("9"));
//       assert( l.size() == 8 );
//       l.printNodes();
//       
//       //TEST #5c - remove node with value is same as other
//       l.addAtEnd("4");
//       l.addAtEnd("11");
//       l.printNodes();
//       l.remove("4");
//       assert( l.head().equals("1") );
//       assert( l.tail().equals("11"));
//       assert( l.size() == 9 );
//       l.printNodes();
       
       
    }
    
    
}
