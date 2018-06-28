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
public class Queue implements QueueInterface {
    public static final int DEFAULT_QUEUE_SIZE = 10;
    private int front = -1;
    private int back = -1;
    private Integer[] queue;
    
    public Queue(){
        this.queue = new Integer [DEFAULT_QUEUE_SIZE];
    }
    
    public Queue(int size){
        this.queue = new Integer [size];
    }
    
    public Integer front() {
        if (this.isEmpty())return -1;
        return this.queue[this.front];
    }

    public Integer back() {
        if (this.isEmpty())return -1;
        return this.queue[this.back];
    }

    public void enqueue(Integer value) {
        if (value >= 0){
            if (this.isEmpty()){
                this.front = 0;
                this.back = 0; 
                this.queue[this.front] = value; 
            } else if (this.isFull()){
                System.out.println("Can not add any more values is full");
            }else{
                this.back++;
                int backPlacement = this.back%capacity();
                this.back = backPlacement;
                this.queue[backPlacement] = value; 
            }
        }else {
            System.out.println("This value can not be added");
        }
        
        
    }

    public Integer dequeue() {
        if( this.isEmpty() ) {
            return -1;
        }else if (this.front == this.back){
            Integer value = this.queue [this.front];
            this.makeEmpty();
            return value;
        } else{
            Integer front = this.queue [this.front];
            this.front++;
            return front;
        }
        
    }

    public int size() {
        if (this.isEmpty()){
            return 0;
        }else if (this.capacity() == 1){
            return 1;
        }else if (this.back < this.front){
            int size = this.back + this.capacity() - this.front + 1;
            return size;
        }else {
            int size = this.back - this.front + 1;
            return size;
        }
    }

    public int capacity() {
        int length = this.queue.length;
        return length;
    }

    public boolean isEmpty() {
        if( this.front == -1 ) return true;
        return false;
    }

    @Override
    public boolean isFull() {
        if( this.size() == this.capacity() ) return true;
        return false;
    }

    @Override
    public void makeEmpty() {
        this.front = -1;
        this.back = -1;
    }
    
    
}
