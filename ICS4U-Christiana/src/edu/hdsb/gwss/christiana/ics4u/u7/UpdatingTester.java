/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author 1wuchr
 */
public class UpdatingTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        final char Senior = 83;
        final char Junior  = 93;
        final char Intermediate  = 73;
        
        DataBase db = new DataBase();
        
        Employee e1 = new Employee (2345678, 5, "Gillian", "Johnson", "Apple Inc.", false, Junior, 100000.94);
        Employee e2 = new Employee (3345534, 3, "Ali", "Al-Saeed", "Civil Construction", false, Junior, 50000.94);
        
        db.open();
        db.save(e1);
        db.save(e2);
        
        db.close();
                
    }
}
