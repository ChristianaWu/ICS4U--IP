/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u1;

/**
 *
 * @author 1wuchr
 */
public class Convertions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here\
        
        //int to long 
        int i = 1334;
   
        long j = i;
        //int can fit if nto al long  you just have to tell it what it is changing to 
        
        long vrb = 244543;
        int e = (int) vrb;
        // When you try to fit a long into the int what happens is that the long will get cut though
        //since the long is 64 bit
        //Only need the (int)<----(cast) when going form a bigger to a smaller data type
        
        
        int value = Integer.parseInt("1246");
        double value2 = Double.parseDouble("-3e2");
        
        String a = Integer.toString(5);
        
        int i2 = 76;
        System.out.println((char) 0xf);
        //We use 32 in UTF-32 encoding
        //0x is telling java that the uncode is hexa decimal
        
        //float to double
        float w = 5454545.6767f;
        //try to a avoid using float when being percise
        //Use float when you want to be effcient
        //Always add a f at the end of the number when using float
        double x = w; 
        
        boolean x2 = true;
        String y = Boolean.toString(x2);
        System.out.println(x2);
        
        boolean z = Boolean.parseBoolean("True");
        //can onlt type in true in any other thing in the brakets will be false
        
        
        
    }
    
}
