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
public class StackClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Stack s = new Stack();  
       // TEST #1 - EMPTY STACK
       assert( s.top() == -1 );
       assert( s.pop() == -1 );
       assert( s.size() == 0 );
       assert( s.capacity() == Stack.DEFAULT_STACK_SIZE );
       assert( s.isEmpty() );
       assert( !s.isFull() );

       Stack s2 = new Stack (1);
       // TEST #2 - 1 stack size
       s2.push(5);
       assert( s2.top() == 5 );
       assert( s2.size() == 1 );
       assert( !s2.isEmpty() );
       assert( s2.isFull() );
       assert( s2.pop() == 5 );
       assert( s2.capacity() == 1 );
       assert( s2.isEmpty() );
       assert( !s2.isFull() );
       
       Stack s3 = new Stack ();
       // TEST #3 - Not full stack
       s3.push(5);
       s3.push(6);
       s3.push(7);
       s3.push(10);
       assert( s3.top() == 10 );
       assert( s3.size() == 4 );
       assert( s3.pop() == 10 );
       assert( s3.capacity() == Stack.DEFAULT_STACK_SIZE );
       assert( !s3.isEmpty() );
       assert( !s3.isFull() );
        
       Stack s4 = new Stack ();
       // TEST #4a - full stack
       for (int i=0; i<10; i++ ){
           s4.push(i);
       }
       assert( s4.top() == 9 );
       assert( s4.size() == 10 );
       assert( !s4.isEmpty() );
       assert( s4.isFull() );
       
       //TEST #4b - Stack overflow
       s4.push(5);
       assert( s4.top() == 9 );
       assert( s4.size() == 10 );
       assert( !s4.isEmpty() );
       assert( s4.isFull() );
       assert( s4.pop() == 9 );
       assert( s4.top() == 8 );
       assert( s4.capacity() == Stack.DEFAULT_STACK_SIZE );
       assert( !s4.isEmpty() );
       assert( !s4.isFull() );
       
       //TEST #5 - Making stack empty
       s4.makeEmpty();
       assert( s4.top() == -1 );
       assert( s4.size() == 0 );
       assert( s4.isEmpty() );
       assert( !s4.isFull() );
       assert( s4.pop() == -1 );
       
       //TEST #6 - Add negative numbers
       for (int i=0; i<6; i++ ){
           s4.push(i);
       }
       s4.push(-5);
       assert( s4.top() == 5 );
       assert( s4.size() == 6 );
       assert( !s4.isEmpty() );
       assert( !s4.isFull() );
       assert( s4.pop() == 5 );
    }
    
}
