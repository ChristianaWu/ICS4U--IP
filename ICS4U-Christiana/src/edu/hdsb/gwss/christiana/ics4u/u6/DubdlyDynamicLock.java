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
public class DubdlyDynamicLock extends FixedLock{
    protected int[] usersCombo;
    public DubdlyDynamicLock (){
        super();
        this.usersCombo = new int [4];
        this.lockCode = this.usersCombo;
        this.open = false;
    }
    
    public DubdlyDynamicLock (int firstDig, int secondDig, int thirdDig, int fourthDig){
        super();
        this.usersCombo = new int [4];
        this.open = true;
        this.setLockCode(firstDig, secondDig, thirdDig, fourthDig);
        this.lockLock();
    }
    
    public void setLockCode(int firstDig, int secondDig, int thirdDig, int fourthDig){
        if (!this.open){
            System.out.println("Lock is not open can not set lock combo");
        }else{
            if (firstDig > 9 || firstDig < 0 || secondDig > 9 || secondDig < 0 ||thirdDig > 9 || thirdDig < 0 ){
                System.out.println("One or more of the numbers are not in bettween 0 and 9 can not be combo.");
            }else{
                this.usersCombo[0] = firstDig;
                this.usersCombo[1] = secondDig;
                this.usersCombo[2] = thirdDig;
                this.usersCombo[3] = fourthDig;
                this.lockCode = this.usersCombo;
                this.triesToUnlock = 0;
            }
        }
    }
    
    public boolean openLock(int firstDig, int secondDig, int thidDig, int fourthDig) {
        this.userInput = new int [4];
        this.userInput[0] = firstDig;
        this.userInput[1] = secondDig;
        this.userInput[2] = thidDig;
        this.userInput[3] = fourthDig;
        if (this.triesToUnlock == 3){
            System.out.println("You have have disabled your lock!!"); 
            return false;
        }else {
            return this.isRightCombo(this.userInput);
        }
    }
}
