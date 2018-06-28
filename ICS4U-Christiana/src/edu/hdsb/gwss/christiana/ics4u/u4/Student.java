/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u4;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 1wuchr
 */
public class Student {
    //Class consent
    public final static String SCHOOL = "Grath Webb";
    
    //Class variable 
    private int nextid;//Primary key


    
    //Object vraibale 
    private int studtenNumber;
    private String firstName;
    private String lastName;
    private Date dob;
    private int grade;

    public Student() {
    }
    
    public Student(int studtenNumber) {
        this.studtenNumber = studtenNumber;
    }

    public Student(String firstName, String lastName, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public int getStudtenNumber() {
        return studtenNumber;
    }

    private void setStudtenNumber(int studtenNumber) {
        this.studtenNumber = studtenNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    
    //Fancy way to display it
    @Override
    public String toString() {
        return "Student{" + "studtenNumber=" + studtenNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Student other = (Student) obj;
        if (this.studtenNumber > 0 && this.studtenNumber == other.studtenNumber) {
            return true;
        }
        if (this.studtenNumber != other.studtenNumber) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        return true;
    }
    
   public static void main(String[] args) {
       Date date = new Date();
       Student a = new Student (1);
       Student b = new Student (1);
       Student c = new Student (2);
       Student d = a;
       Student e = new Student ("first", "Last", date);
       Student f = new Student ("first", "Last", date);
       
       
       System.out.println( a==b); // False Difference Objects
       System.out.println(a==d); // True same object 
       System.out.println(a.equals(b));//True same id
       System.out.println(a.equals(c));//False different id
       
       System.out.println(e == f);
       System.out.println(e.equals(f));
   }
    
    
    //Incapalting data, forcing the user to use setters and getters
    
    /** 
         * What a class is 
         * What is the difference of a class and an object 
         * Object is an instance Variable 
         * final static //Class consent
         * You want an ID this will help the data base when trying to identify certain things
         * Setters and getter are capstales doing so is called incapacitate
         * Constructors are special type of method that is only called once 
         * reference things by primary key 
         * .== is just seeing is if it point to the same thing in memeory 
         * 
         */
}
