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
public class Stack implements StackInterface  {

    public static final int DEFAULT_STACK_SIZE = 10;
    
    private int top;   
    private int[] stack;

    public Stack() {
        this.top = -1;
        this.stack = new int[DEFAULT_STACK_SIZE];
    }
    
    public Stack (int size){
        this.top = -1;
        this.stack = new int[size];
    }
    
    public int top() {
        if( this.isEmpty() ) return -1;
        return stack[this.top];
    }

    public int pop() {
        if( this.isEmpty() ) return -1;
            int top = stack[this.top];
            this.top = this.top-1;
            return top;
   
    }

    public void push(int value) {
        if (value >= 0){
            if(!this.isFull()){
                this.top++;
                this.stack[this.top] = value;
            }else {
                this.top = this.top;
            }
        }else{
            System.out.println("This value can not be added");
        }
        
    }

    public int size(){ 
        return this.top + 1;
    }

    public int capacity() {
        return this.stack.length;
    }

    public boolean isEmpty() {
        if( this.top == -1 ) return true;
        return false;
    }

    
    public boolean isFull() {
        if (this.top == -1 || this.top < this.capacity()-1) return false;
        return true;
    }

    public void makeEmpty() {
        this.top = -1;
    }
    
}
