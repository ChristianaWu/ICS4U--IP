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
 * @author Christy Wu
 */
public class ReadTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        long recordNumber;
        Scanner input = new Scanner( System.in );
        RandomAccessFile recordFile = new RandomAccessFile("employee_info.txt", "rw");
        //System.out.println(recordFile.length());
        
        long numRecords = recordFile.length() / Employee.RECORD_SIZE;
        System.out.println( "\nThere are " + numRecords + " records currently in the file." );
         
        System.out.print( "Which record do you want [1 - " + numRecords + "] or 0 to exit? \n" + "User Input: " );
        recordNumber = input.nextLong();
        
        while( recordNumber > 0 && recordNumber<=numRecords) {         
            System.out.println( "Record number " + recordNumber + ": " );
            System.out.println( DataBase.get(recordNumber, recordFile).toString() );
            System.out.print( "Which record do you want [1 - " + numRecords + "] or 0 to exit? \n" + "User Input: " );
            recordNumber = input.nextLong();
        
        }
        
    }
    
}
