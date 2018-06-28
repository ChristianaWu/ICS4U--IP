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
public class DubdlyLockClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] combo;
        DubdlyLock a = new DubdlyLock(); 
        combo = a.getLockCode();
        System.out.println( combo[0] + "-" + combo[1] + "-" + combo[2]);
        //Test #1: Test the function 
        assert (!a.isOpen() );
        assert (a.isLocked());
        assert (a.getSerialNumber() == 1);
        assert (a.getMax() == 39);
        assert (a.getMin() == 0);
        assert (a.getLockCode() == a.lockCode);
        
        //Test #2: Try to ppen the lock 
        assert (a.openLock(combo[0], combo[1], combo[2]));
        assert (a.isOpen() );
        assert (!a.isLocked());
        
        //Test #3: Open a lock that is already open
        assert (a.openLock(combo[0], combo[1], combo[2]));
        
        //Test #4: Lock lock back up then disable the lock 
        a.lockLock();
        
        assert (!a.openLock(3, 4, 36) );
        assert (!a.openLock(3, 3, 36) );
        assert (!a.openLock(4, 4, 36) );
        assert (!a.openLock(4, 4, 36));
        
        //Test #5: Find the lock using PK 
        DubdlyLock a2 = new DubdlyLock(); 
        assert (a2.getSerialNumber() == 2);
        assert (!a2.equals(a));
    }
    
}
