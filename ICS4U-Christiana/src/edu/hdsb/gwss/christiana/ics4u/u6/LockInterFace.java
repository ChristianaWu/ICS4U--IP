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
public abstract interface LockInterFace {

    
    public boolean openLock (int firstDig, int secondDig, int thidDig );
    /** 
     * This will return to see if the code entered is right  
     * @param usersGuess
     * @return 
     */
    
    public boolean isRightCombo(int[] usersGuess);
    /** 
     *  
     * @param usersGuess
     * @return 
     */
    
    public boolean isOpen();
    
    public boolean isLocked();
    
    public void lockLock ();
    
    
    
}
