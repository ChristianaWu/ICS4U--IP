/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u7;

import java.util.Objects;

/**
 *
 * @author 1wuchr
 */
public class Employee {
    private long phoneNumb;
    private int emplyeeID;
    private double salary;
    private String firstName;
    private String lastName;
    private String company;
    private boolean masterDagree;
    private char positionRanking;
    protected static final int RECORD_SIZE = 107;
    protected static final int PHONE_LENGTH = 7;
    protected static final int SALARY_LENGTH = 11;
    protected static final int EID_LENGTH = 6;
    protected static final int LASTNAME_LENGTH = 15;
    protected static final int COMPANY_LENGTH = 15;
    protected static final int FIRSTNAME_LENGTH = 12;
    
    public Employee(){
        this.emplyeeID = -1;
        this.company = "N/A";
        this.firstName = "N/A";
        this.lastName = "N/A";
    }
    
    public Employee(long phoneNumb, int emplyeeID, String firstName, String lastName, String company, boolean masterDagree, char positionRanking, double salary) {
        this.emplyeeID = emplyeeID;
        this.phoneNumb = phoneNumb;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.masterDagree = masterDagree;
        this.positionRanking = positionRanking;
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "Employee{" + " emplyeeID=" + emplyeeID + ", salary=" + salary + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company + ", masterDagree=" + masterDagree + ", positionRanking=" + positionRanking + ", phoneNumb=" + phoneNumb +"}";
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
        final Employee other = (Employee) obj;
        if (this.phoneNumb != other.phoneNumb) {
            return false;
        }
        if (this.emplyeeID != other.emplyeeID) {
            return false;
        }
        if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.salary)) {
            return false;
        }
        if (this.masterDagree != other.masterDagree) {
            return false;
        }
        if (this.positionRanking != other.positionRanking) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        return true;
    }
    
    
    
    public long getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(long phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public int getEmplyeeID() {
        return emplyeeID;
    }

    public void setEmplyeeID(int emplyeeID) {
        this.emplyeeID = emplyeeID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        StringBuilder temp = new StringBuilder();

        if ( this.firstName != null ) {
            temp.append( this.firstName.trim() );
        } else {
            temp.append( "TBD" );
        }

        // trucates or pads the string
        temp.setLength( FIRSTNAME_LENGTH );
        this.firstName = temp.toString();
        return firstName;
    }

    public void setFirstName(String firstNam) {
        this.firstName = firstNam;
    }

    public String getLastName() {
        StringBuilder temp = new StringBuilder();

        if ( this.lastName != null ) {
            temp.append( this.lastName.trim() );
        } else {
            temp.append( "TBD" );
        }

        // trucates or pads the string
        temp.setLength( LASTNAME_LENGTH );
        this.lastName = temp.toString();
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        StringBuilder temp = new StringBuilder();

        if ( this.company != null ) {
            temp.append( this.company.trim() );
        } else {
            temp.append( "TBD" );
        }

        // trucates or pads the string
        temp.setLength( COMPANY_LENGTH );
        this.company = temp.toString();
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean hasMasterDagree() {
        return masterDagree;
    }

    public void setMasterDagree(boolean masterDagree) {
        this.masterDagree = masterDagree;
    }

    public char getPositionRanking() {
        return positionRanking;
    }

    public void setPositionRanking(char positionRanking) {
        this.positionRanking = positionRanking;
    }
    
    public boolean isValid (){
        if (this.company == null || this.firstName == null || this.lastName == null)return false;
        return true;
    }
            
}
