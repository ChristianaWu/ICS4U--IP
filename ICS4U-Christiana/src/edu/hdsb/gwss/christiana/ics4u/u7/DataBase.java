/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1wuchr
 */
public class DataBase {
    private RandomAccessFile recordFile;
    public void DataBase(){
        
    }
    
    public void open() throws FileNotFoundException{
        if (recordFile == null){
           try {
               recordFile = new RandomAccessFile ("employee_info.txt", "rw");
               System.out.println("File is open!");
           } catch (FileNotFoundException ex) {
               Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else {
            System.out.println("This file is already open!!");
        }   
    }

    public void close() throws IOException{
       if (recordFile != null){
           try {
               recordFile.close();
               recordFile = null;
               System.out.println("Flie is Closed!");
           } catch (FileNotFoundException ex) {
               Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else {
           System.out.println("This file is alreayd closed");
       } 
    }
    
    public Employee save( Employee e) throws IOException{
        if (e.isValid()){
            if (e.getEmplyeeID() == -1 ){
                recordFile.seek(recordFile.length());
                int numberRecords = (int) (recordFile.length() / Employee.RECORD_SIZE) +1;
                e.setEmplyeeID(numberRecords);
            }else {
                recordFile.seek((e.getEmplyeeID() -1)* Employee.RECORD_SIZE );
            } 
            recordFile.writeInt(e.getEmplyeeID());
            recordFile.writeLong(e.getPhoneNumb());
            recordFile.writeChars(e.getFirstName());
            recordFile.writeChars(e.getLastName());
            recordFile.writeChars(e.getCompany());
            recordFile.writeDouble(e.getSalary());
            recordFile.writeChar(e.getPositionRanking());
            recordFile.writeBoolean(e.hasMasterDagree());

            return e;
        }else{
            System.out.println("This emplyee is not valid!!");
            return e;
        }
        
    }
    
    public static Employee get( long dbID , RandomAccessFile recordFile) throws IOException{
        Employee e = new Employee( );
        long position = Employee.RECORD_SIZE * (dbID - 1);
        recordFile.seek( position );
        
        e.setEmplyeeID(recordFile.readInt());    
        e.setPhoneNumb(recordFile.readLong());

        char firstName[] = new char[Employee.FIRSTNAME_LENGTH];
        for( int i=0; i < Employee.FIRSTNAME_LENGTH; i++ ) {
            firstName[i] = recordFile.readChar();
        }
        e.setFirstName( new String( firstName ) );

        char lastName[] = new char[Employee.LASTNAME_LENGTH];
        for( int i=0; i < Employee.LASTNAME_LENGTH; i++ ) {
            lastName[i] = recordFile.readChar();
        }
        e.setLastName( new String( lastName ) );

        char company[] = new char[Employee.COMPANY_LENGTH];
        for( int i=0; i < Employee.COMPANY_LENGTH; i++ ) {
            company[i] = recordFile.readChar();
        }
        e.setCompany( new String( company ) );
        e.setSalary(recordFile.readDouble());
        e.setPositionRanking(recordFile.readChar());
        e.setMasterDagree(recordFile.readBoolean());
        
        return e;
    }
    
}
