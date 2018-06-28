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
public class DubdlyLock extends MasterLock{
    public DubdlyLock (){
        super();
        this.max = 39;
        this.genarateRandomCombo();
    }
}
