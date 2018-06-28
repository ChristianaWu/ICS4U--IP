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
public class AndoridLock extends FixedLock{
    protected int[] usersCombo;
    public AndoridLock (){
        super();
        this.usersCombo = new int [3]; 
        this.open = true;
    }
    
    public AndoridLock (int firstDig, int secondDig, int thidDig){
        super();
        this.usersCombo = new int [3];
        this.open = true;
        this.setLockCode(firstDig, secondDig, thidDig);
        this.lockLock();
    }
    
    public void setLockCode(int firstDig, int secondDig, int thirdDig){
        if (!this.open){
            System.out.println("Lock is not open can not set lock combo");
        }else{
            if (firstDig > 9 || firstDig < 0 || secondDig > 9 || secondDig < 0 ||thirdDig > 9 || thirdDig < 0 ){
                System.out.println("One or more of the numbers are not in bettween 0 and 9 can not be combo.");
            }else{
                this.usersCombo[0] = firstDig;
                this.usersCombo[1] = secondDig;
                this.usersCombo[2] = thirdDig;
                this.lockCode = this.usersCombo;
                this.triesToUnlock = 0;
            }
        }
        
    }

}
