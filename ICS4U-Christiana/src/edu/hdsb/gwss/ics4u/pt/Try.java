/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.pt;

import java.util.Scanner;

/**
 *
 * @author Christiana Wu
 */
public class Try {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       int x = 4;
       int sum=0;
        
        while (x != 0) {
           sum = sum+x;
            System.out.print("Enter a number (-1 to quit): ");
           x = input.nextInt(); 
           
        };
       
    }
    public int getNumber(Scanner input){
         return 1;
     }
}
