 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1wuchr
 */
public class lesson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //about to use one variable name for many vribles 
        //size does not have to be diclred right away you cna ask the user for a size then diclare it 
        //not dynmic in size (fixed size)
        
        
        int[] marks = new int[20];
        
        //marks[0]=12;
        
        for ( int i=0; i<marks.length; i++){
            marks[i] = (int) (Math.random()*50)+50;
        }
        
        for ( int i=0; i<marks.length; i++){
            System.out.println(marks[i]);
        }

        //If the class doubles in size you have to make a new array 
        int [] marks3 = new int [marks.length*2];
        
        for ( int i=0; i<marks3.length; i++){
            marks3[i] = marks[i];
        }
        
        //Array list 
        
        ArrayList data = new ArrayList(); //this is a dynamic array it can grow or srink does not matter 
        
        //for ( int i=0; i<data.size; i++){//when using array list it is not a length it is a size
            
        data.add(1);
        data.add("hello");
        data.add(new Scanner (System.in));
        data.add (2.3);
        
        data.remove(0);//This will crash is you do this 
        
        //to get the data 
        Integer x = (Integer) data.get(2);// when getting the item from index it will come out as an object
        
        //if you do not case the item you are getting it will come out as a genaric object
        Object x2 = data.get (0);
        
        //When you get the container that is an object you can not do anything with it because it is a ginaric contaner 
        //But if you pull it as a specific data type then you get all the functions of that data type
        //If you need more functionallity you create objects
        //Array List is a rapper for a list 
        int x3 = (Integer)data.get(0);
        
        //Array list allows you to mix thing in the array but you should not do it. HTis is when you hve a genaric ArrayList
        
        ArrayList <String> data2 = new ArrayList();
        //Create a dimond cast to specify the array list
        
        data2.add("hello");
        
        //Remove remmoves the object, get gets that the object referance 
        
        String y = data2.get(0);
        
        //if you were to .remove you get the refence and remove that variable
        //When you remove it the variable will exist in memeory somewhere but since iti s removed then the data is empty 
        System.out.println(x);//Will print hello
        System.out.println(data.get(0));//Wll crash 
        
        ArrayList <String> data3 = new ArrayList();
        
//        String b = "hi";
//        String c = "hi";
//        
//        System.out.println(b==c);
//        System.out.println(b.equals(y));
        
        data3.add("abc");
        data3.add("123");
        
//        for (int i=0; i<data3.size();i++){
//            System.out.println(data.get(i));
//        }
        
        
        for (String e : data3){
            System.out.println(e);
        }
        
        //Array list has a linear search 
//        data3.add(b);
//        data3.add(c);
        
        //data.remove(x);
        //There is functionalilty that is in an array list 
        
        
        
        
        
        
        
        
    
    }
    
}
