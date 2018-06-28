/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u4;

/**
 *
 * @author 1wuchr
 */
public class BookClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //EMPTY BOOK 
        //Confused what the constuctor does 
        Book a= new Book();
        
        a.setAuthor("Muir");
        a.setTitle("computer Programming");
        a.setPages(500);
        
        System.out.println(a.toString());// or just use a
        
        
        //BOOK BY ID
        Book b = new Book(123);
        System.out.println(b);
        
        //BOOK BY SCONDARY KEY
        
        Book c = new Book("computer Programming", 2, "Muir");
        System.out.println(c);
        Book d = new Book("computer Programming", 2, "Muir");
        System.out.println(d);
        
        System.out.println(a.equals(a));
        
        /** 
         * What a class is 
         * What is the difference of a class and an object 
         * Object is an instance Variable 
         * final static //Class constent 
         */
        
        
        
        
    }
    
}
