/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u3;

/**
 *
 * @author 1wuchr
 */
public class FiveTerms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Sequence one 
        //System.out.println( SequenceOne(-2) );
        System.out.println( SequenceTwo(1) );
        System.out.println( SequenceTwo(2) );
        System.out.println( SequenceTwo(3) );
        System.out.println( SequenceTwo(4) );
        System.out.println( SequenceTwo(5) );
    }
    
    public static int SequenceOne (int n){
       if( n < 1 ) return -1;
       if( n == 1 ) return 3;       
       return SequenceOne(n-1) + 2;
    }
    
    public static double SequenceTwo (int n){
        if (n < 0) return -1;
        if (n == 1) return 2;
        return 1 - 1/SequenceTwo(n-1);
    }
    
    public static double SequenceThree (int n){
        if (n < 0) return -1;
        if (n == 1) return 2;
        return n- SequenceTwo(n-1);
    }
    
    public static int SequenceFour (int n){
        if (n < 0) return -1;
        if (n == 1) return 1;
        if (n == 2) return 3;
        return SequenceFour(n-1)+SequenceFour(n-2) ;
    }
    public static double SequenceFive (int n){
        if (n < 0) return -1;
        if (n == 1) return 1;
        if (n == 2) return 3;
        return SequenceTwo(n-1)+SequenceTwo(n-2) ;
    }
    
    
    
}
