/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u6;


/**
 *
 * @author 1wuchr
 */
public class MasterLock extends Locks{

    public MasterLock (){
        super();
        this.lockCode = new int [3];
        this.max = 59;
        this.genarateRandomCombo();
        this.open = false;
        
    }
    
    protected void genarateRandomCombo(){
        int digitForCode;
        for (int i=0; i<this.lockCode.length; i++){
            digitForCode = (int) ( Math.random() * (this.max + this.min) );
            this.lockCode [i] = digitForCode;
        }        
    }
    
}
