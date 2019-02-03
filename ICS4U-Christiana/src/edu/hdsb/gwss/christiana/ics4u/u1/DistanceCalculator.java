/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
6378.8 * arccos[sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lon2 - lon1)]
6378.8 * arccos[sin(lat1/57.2958) * sin(lat2/57.2958) + cos(lat1/57.2958) * cos(lat2/57.2958) * cos(lon2/57.2958 - lon1/57.2958)]
*/
package edu.hdsb.gwss.christiana.ics4u.u1;

import static java.lang.Math.cos;
import static java.lang.Math.acos;
import static java.lang.Math.sin;
import java.util.Scanner;

/**
 *
 * @author 1wuchr
 */
public class DistanceCalculator {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables 
        double lon1, lat1, lon2, lat2, GCD;
        String p1, p2;
        
        //Objects
        Scanner input = new Scanner (System.in);
        
        //Input
        System.out.print("What is place 1: ");
        p1 = input.nextLine();
                
        System.out.print("The longitude "+ p1+ "is in degrees: ");
        lon1 = input.nextDouble();
        
        System.out.print("The latitude "+ p1+ "is in degrees: ");
        lat1 = input.nextDouble();
        
        System.out.print("What is place 2: ");
        p2 = input.next();
        
        System.out.print("The longitude "+ p2+ "is in degrees: ");
        lon2 = input.nextDouble();
        
        System.out.print("The latitude "+ p2+ "is in degrees: ");
        lat2 = input.nextDouble();
        
        //Math
        GCD = 6378.8 * acos(sin(lat1/57.2958) * sin(lat2/57.2958) + cos(lat1/57.2958) * cos(lat2/57.2958) * cos(lon2/57.2958 - lon1/57.2958));
        
        //Output
        System.out.println("\nThe Great Distance is " + GCD);
    }
    
}
