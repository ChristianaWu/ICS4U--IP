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
public class AndoridClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AndoridLock a = new AndoridLock(); 
        //Test #1: When the lock combo is not set rit away 
        assert (a.isOpen() );
        assert (!a.isLocked() );
        assert (a.getSerialNumber() == 1);
        assert (a.getMax() == 9);
        assert (a.getMin() == 0);
        assert (a.openLock(4, 5, 6));
        
        ///Test #2: Set and see lock combo 
        a.setLockCode(5, 6, 9);
        assert (a.retriveCombo() == a.lockCode);
        assert (a.retriveCombo() == null);

        AndoridLock a2 = new AndoridLock(4, 5, 6); 
        //Test #3: Try to open a lock and lock it up
        assert (!a2.isOpen() );
        assert (a2.isLocked() );
        assert (a.getSerialNumber() == 2);
        assert (a2.openLock(4, 5, 6));
        assert (a2.isOpen() );
        a2.lockLock();
        assert (!a2.isOpen() );
        
        //Test #4: Locked out of lock after tree tries 
        assert (!a2.openLock(6, 5, 6) );
        assert (!a2.openLock(7, 5, 6) );
        assert (!a2.openLock(8, 5, 6) );
        assert (!a2.openLock(4, 5, 6) );
        
        //Test #5: Try to set a locked lock and set lock wit numbers our of range 
        a2.setLockCode(2, 4, 6);
        a.setLockCode(2, 45, 6);
        
        //Test #5: use PK to find lock
        assert (!a2.equals(a) );
        
    }
    
}
