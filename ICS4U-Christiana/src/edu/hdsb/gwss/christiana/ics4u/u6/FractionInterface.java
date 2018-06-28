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
public interface FractionInterface {
    public double size();
    
    public Fraction larger(Fraction f);
    
    public Fraction larger (Fraction f, Fraction g);
    
    public Fraction time (Fraction f);
    
    public Fraction time (Fraction f, Fraction g);
    
    public void reduced ();
    
    public void inverted ();
    
}
