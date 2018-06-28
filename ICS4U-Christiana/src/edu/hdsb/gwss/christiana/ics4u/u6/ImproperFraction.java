/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u6;

/**
 *
 * @author 1wuchr
 */
public class ImproperFraction extends Fraction{
    public ImproperFraction (){
        super();
    }
    
    public ImproperFraction (int numerator , int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public void toMixed(){
        this.wholeNumb = this.numerator/this.denominator;
        this.numerator = this.numerator-this.wholeNumb;
    }
}
