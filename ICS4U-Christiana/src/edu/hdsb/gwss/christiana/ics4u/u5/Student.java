/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u5;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 1wuchr
 */
public class Student {
    private int id;
    private long phoneNumber;
    private String firstName;
    private String lastName;

    public Student() {
        this.firstName = null;
        this.lastName = null;
        this.phoneNumber = -1;
        this.id = -1;
    }
    
    public Student(String firstName, String lastName, int studtenNumber, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = studtenNumber;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
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
        if (this.id != other.id) {
            return false;
        }
        if (this.hashCode() != other.hashCode()) {
            return false;
        }
        if (this.phoneNumber != other.phoneNumber) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }
    
    public int getId() {
        return id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    
}
