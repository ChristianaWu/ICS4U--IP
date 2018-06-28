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
public class QueueClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Queue q = new Queue();  
       // TEST #1 - EMPTY STACK
       assert( q.front() == -1 );
       assert( q.back() == -1 );
       assert( q.dequeue() == -1);
       assert( q.capacity() == Queue.DEFAULT_QUEUE_SIZE );
       assert( q.isEmpty() );
       assert( !q.isFull() );
       
       Queue q2 = new Queue(1);  
       // TEST #2 - size 1
       q2.enqueue(2);
       assert( q2.front() == 2 );
       assert( q2.back() == 2);
       assert( q2.size() == 1);
       assert( !q2.isEmpty() );
       assert( q2.isFull() );
       assert( q2.dequeue() == 2);
       assert( q2.capacity() == 1 );

       Queue q3 = new Queue();
       // TEST #3a - Not full or empty
       for (int i = 0; i < 6; i++){
           q3.enqueue(i);
       }
       assert( q3.front() == 0 );
       assert( q3.back() == 5);
       assert(q3.size() == 6);
       assert( q3.capacity() == Queue.DEFAULT_QUEUE_SIZE);
       assert( !q3.isEmpty() );
       assert( !q3.isFull() );
       assert( q3.dequeue() == 0);
       assert (q3.front()== 1);
       
       // TEST #3b - Make te queue empty
       q3.makeEmpty();
       assert( q3.front() == -1 );
       assert( q3.back() == -1);
       assert(q3.size() == 0);
       assert( q3.capacity() == Queue.DEFAULT_QUEUE_SIZE);
       assert( q3.isEmpty() );
       assert( !q3.isFull() );
       
       //TEST #4a - Full queue
       for (int i = 0; i < Queue.DEFAULT_QUEUE_SIZE; i++){
           q3.enqueue(i);
       }
       assert( q3.front() == 0 );
       assert( q3.back() == 9);
       assert(q3.size() == 10);
       assert( q3.capacity() == Queue.DEFAULT_QUEUE_SIZE);
       assert( !q3.isEmpty() );
       assert( q3.isFull() );
       assert( q3.dequeue() == 0);
       
       //TEST #4b - Queue workin in a circle
       q3.enqueue(11);
       assert( q3.front() == 1 );
       assert( q3.back() == 11);
       assert(q3.size() == 10);
       assert( q3.capacity() == Queue.DEFAULT_QUEUE_SIZE);
       assert( !q3.isEmpty() );
       assert( q3.isFull() );
       
       //TEST #4c - Queue overflow
       q3.enqueue(11);
       assert( q3.front() == 1 );
       assert( q3.back() == 11);
       assert(q3.size() == 10);
       assert( q3.capacity() == Queue.DEFAULT_QUEUE_SIZE);
       assert( !q3.isEmpty() );
       assert( q3.isFull() );
       
       
       q3.dequeue();
       //TEST #5 - Add negative number 
       q3.enqueue(-11);
       assert( q3.front() == 2 );
       assert( q3.back() == 11);
       assert(q3.size() == 9);
       assert( !q3.isEmpty() );
       assert( !q3.isFull() );
 
      
    }
    
}
