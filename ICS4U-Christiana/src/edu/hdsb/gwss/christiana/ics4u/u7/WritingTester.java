/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Christy Wu
 */
public class WritingTester {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        final char Senior = 83;
        final char Junior  = 93;
        final char Intermediate  = 73;
        DataBase db = new DataBase();
        
        Employee e = new Employee();
        
        Employee e1 = new Employee(8385364, 1, "Lisa", "Wu", "CIBC", false, Senior, 112000.94 );
        Employee e2 = new Employee(4859632, 2, "Alyssa", "Roberts", "Sunlife", true, Intermediate, 100000.09 );
        Employee e3 = new Employee(8954567, 3, "Jason", "Bonds", "Apple", false, Senior, 350000.45 );
        Employee e4 = new Employee(6596355, 4, "Jackson", "Locks", "SAP", true, Junior, 90000.34 );
        
        db.open();
        db.save(e);
        db.save (e1);
        db.save (e2);
        db.save (e3);
        db.save (e4);
        
        //db.close();
    }
    
    
    
}
