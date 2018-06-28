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
public class Circle {
    //TEST QUESTION: What is the difference between a class and a test question 
    //The class is a Blue Print it is jsut the lay out of the the house that is the object 
    //The object is like a house 
    //Objects are contaners that holds all the infomation 
    
    
    //String name = new String();
    //OBJECT VARIABLE 
     private double radius;//Object variable
     //Never want client to get object variables directly always use setter or getter
     
     //CLASS CONSANT
     final static String SHAPE_NAME = "Circle";
     
     //Static will cause it to print out the last thing that you set it as 
     //Adding the final means that it can not be changed so it will print out cicrle for each one 
     
     //CLASS VARIABLE
     
     //CONSTUCTERS
     public Circle (){
         System.out.println("A");
     }
     
     public Circle (double radius){
         System.out.println("B");
         this.setRadius (radius);
         //TEST QUESTION: where does ^^ come from 
         //the this mean it is talking about the radius object (object variable) and that this is 
         //in its own scope the this distiguashes between thep eramaters and the variable
         //MUST USE THIS. ti tell that it is a object variable 
         
     }

    public double getRadius() {
        return radius;
    }
    
    //This is what you want the user to use 
    public void setRadius(double radius) {
        if (radius <= 0 ){
          System.out.println("Invalid radius");
          this.radius = 1;
        }else {
          this.radius = radius;  
        }
        
        
    }
     //Object Consesnts 
     double getDiameter (){
         return this.radius *2;
     }
     
     double getArea (){
         return Math.PI * this.radius *this.radius;
     }
     
     double getCircumfrance (){
         return Math.PI * 2 * this.radius;
     }
     
     void doubleRadius (){
     }
    
  
}
