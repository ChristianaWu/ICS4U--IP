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
class Fraction implements FractionInterface{
    protected static double fraction = 0;
    
    protected int denominator;
    protected int numerator;
    protected int wholeNumb;
    
    public Fraction (){
        this.numerator = 1;
        this.denominator = 1;
    }


    @Override
    public Fraction larger(Fraction f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return true;
    }
    
    @Override
    public String toString() {
        return "Fraction{" + denominator + "/" + numerator + '}';
    }
    
    @Override
    public Fraction larger(Fraction f, Fraction g) {
        double fraction1, fraction2;
        if (f.equals(g)){
            return f;
        }else {
            fraction1 = f.numerator / (double) f.denominator;
            fraction2 = g.numerator / (double) g.denominator;
            
            if (fraction1 < fraction2)return g;
            return f;
        }
    }

    @Override
    public Fraction time(Fraction f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Fraction time(Fraction f, Fraction g) {
        Fraction n = new Fraction(); 
        n.numerator = f.numerator * g.numerator;
        n.denominator = f.denominator * g.denominator;
        
        return n;
    }
    
    protected static int gcd(int p, int q){
        if (q == 0) return p;
        else return gcd (q, p%q);
    }
    
    @Override
    public void reduced() {
        if (this.denominator >= 0){
            gcd (this.numerator, this.denominator);
        } else {
            int diviser = gcd (this.numerator, this.denominator);
            this.denominator = this.denominator/diviser;
            this.numerator = this.numerator/diviser;
        }
    }

    @Override
    public void inverted() {
        if (this.denominator < 0 && this.numerator >= 0){
            this.denominator = this.numerator * (-1);
            this.numerator = this.denominator * (-1);
        }else if (this.denominator >= 0 && this.numerator < 0){
            this.denominator = this.numerator * (-1);
            this.numerator = this.denominator * (-1);
        }else {
            this.denominator = this.numerator;
            this.numerator = this.denominator;
        }
    }

    @Override
    public double size() {
        double magnitutde = this.numerator/(double) this.denominator;        
        return magnitutde;
    }
    
}
