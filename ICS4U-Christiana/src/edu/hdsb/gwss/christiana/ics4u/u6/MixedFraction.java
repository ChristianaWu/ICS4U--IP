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
public class MixedFraction extends Fraction{
    public MixedFraction (){
        super();
        this.wholeNumb = 0;
    }
    
    public MixedFraction (int numerator , int denominator, int wholeNumb){
        this.numerator = numerator;
        this.denominator = denominator;
        this.wholeNumb = wholeNumb;
    }
    
    public void toImproper(){
        this.numerator = this.numerator + (this.wholeNumb*this.denominator); 
        this.wholeNumb = 0; 
    }
    
    @Override
    public String toString() {
        return "Fraction{" + wholeNumb + denominator + "/" + numerator + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fraction other = (Fraction) obj;
        if (this.denominator != other.denominator) {
            return false;
        }
        if (this.numerator != other.numerator) {
            return false;
        }
        if (this.wholeNumb != other.wholeNumb) {
            return false;
        }
        return true;
    }
}
