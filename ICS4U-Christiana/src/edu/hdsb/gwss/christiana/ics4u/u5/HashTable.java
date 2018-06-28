/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u5;

import static java.lang.Math.sqrt;

/**
 *
 * @author 1wuchr
 */
public class HashTable implements HashTableInterface{
    private Student[] studentArr;
    private int sizeCounter = 0;
    public static final int DEFAULT_HASH_SIZE = 53;
    
    public HashTable (){
        studentArr = new Student[DEFAULT_HASH_SIZE];
    }
    
    public HashTable (int arrSize){
        int capactiy = this.checkAndFindNextPrime(arrSize);
        studentArr = new Student[capactiy];
    }
    
    @Override
    public int size() {
       return sizeCounter;
    }

    @Override
    public int capacity() {
        return this.studentArr.length;
    }

    @Override
    public double loadFactor() {
        double loadFactor = (double) this.size()/this.capacity();
        return loadFactor;
    }

    @Override
    public void makeEmpty() {
        this.sizeCounter = 0;
        for(int i=0; i<this.capacity(); i++){
            this.studentArr[i] = null;
        }
    }

    @Override
    public boolean isEmpty() {
        if (this.sizeCounter == 0)return true;
        return false;
    }

    public void rehash() {
        int newIndex;
        double newCapacity = this.size()/0.25;
        int primeCapacity = this.checkAndFindNextPrime((int) newCapacity);
        Student[] holder = this.studentArr;
        this.studentArr = new Student[primeCapacity];
        for (int i= 0; i<holder.length; i++){
            if (holder[i] == null){
                continue;
            }else{
                newIndex = this.hash(holder[i].hashCode());
                this.studentArr[newIndex] = holder[i];
                continue;
            }
        }
    }

    @Override
    public Student get(int key) {
        Student s = null;
        int index = this.hash(key);
        
        while( studentArr[index] != null ) {
            if( studentArr[index].getId() != key) {
                index = (index + 1 ) % capacity();
            }
            else {
                return studentArr[index];
            }
        }
        
        return s;

    }

    @Override
    public void put(int key, Student value) {
        int index = this.hash(key);
        int newIndex;
        if(this.containsKey(key) == false && this.loadFactor()<0.75){
            if (this.studentArr[index] == null){
                this.studentArr[index] = value;
                sizeCounter++;
            }else {
                newIndex = this.linearPorb(index);
                studentArr[newIndex] = value;
                sizeCounter++;
            } 
        }else if (this.containsKey(key) == false && this.loadFactor()>0.75){
            this.rehash();
            index = this.hash(key);
            if (this.studentArr[index] == null){
                this.studentArr[index] = value;
                sizeCounter++;
            }else {
                newIndex = this.linearPorb(index);
                studentArr[newIndex] = value;
                sizeCounter++;
            } 
            
        }else{
            System.out.println("Student already in array.");
        }
    }

    @Override
    public boolean contains(Student value) {        
        return containsKey( value.getId() );
    }

    @Override
    public boolean containsKey(int key) {
        if( get(key) == null ) return false;
        return true;
    }

    @Override
    public int hash(int key) {
        return key%this.capacity();    
    }
    
    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        //check if n is a multiple of 2
        if (num%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=num;i+=2) {
            if(num%i==0)
            return false;
        }
        return true;
    }
    
    private int checkAndFindNextPrime(int input){
        while(this.isPrime(input) == false){
            input++;
        }
        return input;
    }
    
    private int linearPorb (int index){
        int collisionCounter = 0;
        while (this.studentArr[index] != null){
            collisionCounter++;
            if (index == this.capacity()-1){
                index = 0;
            }else{
                index++;
            }  
        }
        System.out.println(collisionCounter);
        return index;
    }
    
    
}
