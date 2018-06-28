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
public class CircleTests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle a = new Circle ();
        Circle b = new Circle ();
        Circle c = new Circle ();
   
        
        System.out.println(a.SHAPE_NAME);
        System.out.println(b.SHAPE_NAME);
        System.out.println(c.SHAPE_NAME);
        
        Circle x = new Circle (4);
        
        //OBJECT A
        System.out.println(a.SHAPE_NAME);
        System.out.println(a.getArea());
        System.out.println(a.getCircumfrance());
        System.out.println(a.getDiameter());
        
        //OBJECT B
        System.out.println(b.SHAPE_NAME);
        System.out.println(b.getArea());
        System.out.println(b.getCircumfrance());
        System.out.println(b.getDiameter());
        
        
        
    }
   
}
