/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
year	19		a
year	100	b	c
b	4	d	e
b + 8	25	f	
b - f + 1	3	g	
19 * a + b - d - g + 15	30		h
c	4	i	k
32 + 2*e + 2*i - h - k	7		j
a + 11*h + 22*j	451	m	
h + j - 7*m + 114	31	month	p
day = p + 1
*/
package edu.hdsb.gwss.christiana.ics4u.u1;

import java.util.Scanner;

/**
 *
 * @author 1wuchr
 */
public class EasterComes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Varible
        int year,a,c,e,b,d,f,h,i,j,k,g,m,p,day,month;
        
        //Objects 
        Scanner input =new Scanner(System.in);
        
        //Input 
        System.out.print("Year is:");
        year = input.nextInt();
        
        //Math
        a = year%19;
        b = year/100;
        c = year%100;
        d=b/4;
        e=b%4;
        f= (b+8)/25;
        g= (b-f+1)/3;
        h= (19 * a + b - d - g + 15)%30;
        i= c/4;
        k=c%4;
        j = (32 + 2*e + 2*i - h - k)%7;
        m= (a + 11*h + 22*j)/451;
        month = (h + j - 7*m + 114)/31;
        p = (h + j - 7*m + 114)%31;
        day = p+1;
        
        //Output
        System.out.println("\nEaster comes on "+ month +"/"+ day + " this year.");
    }
    
}
