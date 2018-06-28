/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u5;

import java.util.Objects;

/**
 *
 * @author Wm.Muir
 */
public class Node implements NodeInterface{
    String value;
    Node pointer;
  
    public Node(String data){
        this.value = data;
    }
    
    public Node(){
    
    }
    
    public Node getNext() {
        return this.pointer;
    }

    public void setNext(Node newNode) {
        this.pointer = newNode;
    }
    
    public String getValue() {
        return this.value;
    }
    

    
}
