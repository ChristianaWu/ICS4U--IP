/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u6;

/**
 *
 * @author Christy Wu
 */
public abstract class Locks implements LockInterFace{
    //Class variables 
    protected static int startingSerialNumber = 0;
    protected final static int min = 0;
    
    //Objcet Vaiable 
    protected int serialNumber;
    protected int[] lockCode;
    int[] userInput;
    protected int triesToUnlock = 0;
    protected int max;
    protected boolean open;
    
    public Locks (){
        startingSerialNumber++;
    }
    
    public static int getMin() {
        return min;
    }

    public int getSerialNumber() {
        return serialNumber = startingSerialNumber;
    }

    public int getMax() {
        return max;
    }

    protected int[] getLockCode() {
        return lockCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Locks other = (Locks) obj;
        if (this.serialNumber != other.serialNumber) {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean openLock(int firstDig, int secondDig, int thidDig) {
        this.userInput = new int [3];
        this.userInput[0] = firstDig;
        this.userInput[1] = secondDig;
        this.userInput[2] = thidDig;
        if (this.triesToUnlock == 3){
            System.out.println("You have have disabled your lock!!"); 
            return false;
        }else {
            if (this.isOpen()){
                System.out.println("Lock is already open");
                return true;
            }
            return this.isRightCombo(this.userInput);
        }
    }

    @Override
    public boolean isRightCombo(int[] usersGuess) {
        for(int i=0; i<this.lockCode.length; i++){
            if (this.lockCode[i] == usersGuess[i]){
            }else {
                this.triesToUnlock++;
                return false;
            }
        }
        this.open = true;
        return true;
    }

    @Override
    public boolean isOpen() {
        if (this.open && this.triesToUnlock != 3) return true;
        return false;
    }

    @Override
    public boolean isLocked() {
        if (!this.open || this.triesToUnlock == 3) return true;
        return false;
    }
    
    @Override
    public void lockLock (){
        this.open = false;
    }
}
