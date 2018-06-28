/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u5;

/**
 *
 * @author 1wuchr
 */
public class LinkList implements LinkListInterface {

    private Node head, tail;

    public LinkList() {
        this.head = null;
        this.tail = null;
    }

    public int size() {
        if (this.isEmpty()) {
            return 0;
        }
        int i = 1;
        Node n = this.head;
        while( n.getNext() != null ) {
            i++;
            n = n.getNext();
        }
        return i;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void addAtFront(String str) {
        if (this.isEmpty()) {
            Node n = new Node(str);
            this.head = n;
            this.tail = n;
        } else {
            Node n = new Node(str);
            n.setNext(head);
            this.head = n;
        }
    }

    public void addAtEnd(String str) {
        if (this.isEmpty()) {
            Node n = new Node(str);
            this.head = n;
            this.tail = n;
        } else {
            Node n = new Node(str);
            this.tail.setNext(n);
            this.tail = n;
        }
    }

    public void remove(String str) {//If it has a a a it would remove this first occurence
        Node n = this.head;
        if (!(str == null || isEmpty())) {

            if (size() == 1 && this.head.getValue().equals(str)) {
                makeEmpty();
            } else if (this.head.getValue().equals(str)) {
                removeHead();
            } else if (this.tail.getValue().equals(str)) {
                removeTail();
            } else {
                while (!n.getNext().getValue().equals(str)) {
                    n = n.getNext();
                }
                Node toDelete = n.getNext();
                n.setNext(toDelete.getNext());
                toDelete.setNext(null);
            }

        }
    }

    public String removeHead() {
        if (this.isEmpty()) {
            return null;
        } else if (this.head == this.tail) {
            String data = this.head.getValue();
            makeEmpty();
            return data;
        } else {
            String headValue = this.head.getValue();
            Node front = this.head;
            this.head = front.getNext();
            front.setNext(null);
            return headValue;

        }
    }

    public String removeTail() {
        if (this.isEmpty()) {
            return null;
        } else if (this.head == this.tail) {
            String data = this.head.getValue();
            makeEmpty();
            return data;
        } else {
            Node head = this.head;
            while (head.getNext().getNext() != null) {
                head = head.getNext();
            }
            String tailVaule = tail.getValue();
            this.tail = head;
            this.tail.setNext(null);
            return tailVaule;
        }
    }

    public String head() {
        if (this.isEmpty()) {
            return null;
        }
        return this.head.getValue();
    }

    public String tail() {
        if (this.isEmpty()) {
            return null;
        }
        return this.tail.getValue();
    }

    public boolean containsNode(String str) {
        Node pointer = this.head;
        int counter = 0;
        while (pointer.getValue().equals(str) == false) {
            if (counter >= this.size() - 1) {
                return false;
            } else {
                pointer = pointer.getNext();
                counter++;
            }
        }
        return true;
    }

    public void printNodes() {
        Node pointer = this.head;
        int counter = 0;

        while (counter <= this.size() - 1) {
            System.out.print(pointer.getValue() + " ");
            pointer = pointer.getNext();
            counter++;
        }
        System.out.println(" ");

    }
}
