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
public abstract class FixedLock extends Locks {
    protected int[] usersCombo;
    private boolean comboSeen = false;
    public FixedLock (){
        super(); 
        this.max = 9;
    }
    
    public int[] retriveCombo(){
        if (!this.comboSeen){
            System.out.println("Combo is shown (you only the combo once): " );
            this.comboSeen = true;
            return this.lockCode;
        }else{
            System.out.println("You can not the combo any more!" );
            return null;
        }
    }
    
    
    
    
}
