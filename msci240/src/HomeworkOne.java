/*
 * Chrisiana wu
 * 2019-10-4
 * Homework 1
 * this is a modual of different method that use stacks adn queues 
 * This does not have an exsact input but each method it self will have an 
 * input it might be and arraylist or satck or queue
 * There is no spacific output 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HomeworkOne {
	public static void removeEvenLength (ArrayList <String> x) {//gets rid of even length string
		int i = 0;
		while(i<x.size()) {
			if (x.get(i).length() % 2 == 0) {
				x.remove(i);
				i--;
			}
			i++;
		}
	}
	
	public static int rangeBetweenZeroes (ArrayList <Integer> x) {//get the range between the farthest 0 in the arraylist
		int range=0, i1,i2;
		
		for (int i = 0; i < x.size(); i++) {
			if (x.get(i) == 0) {
				i1 = i;
				for (int z = x.size()-1; z > 0; z--) {
					if (x.get(z) == 0) {
						i2 = z;
						range = i2 - i1 + 1;
						break;
					}else if (z == 0) {
						range = 1;
						break;
					}
				}
				break;
			}
		}
		return range;
	}
	
	public static void interleave (ArrayList <Integer> a1, ArrayList <Integer> a2) {//weaves the two arraylist together
		int length, i = 0, z = 1;
		int size = a1.size();
		
		if (a1.size() > a2.size()) {
			length = a2.size();
		}else {
			length = a1.size();
		}
		while (i < length) {
			a1.add(z, a2.get(i));
			i++;
			z+=2;
		}	
		if (a2.size() > size) {
			length = a2.size()- (a2.size() - (size));
			
			while (length < a2.size()) {
				a1.add(a2.get(length));
				length++;
			}
		}
	}
	
	public static void collapse (Stack <Integer> s) {//combines the pair of elements together 
		Stack<Integer> x = new Stack <Integer>();
		int sum, size, i = 0;
		
		while (!s.isEmpty()) {
			x.push(s.pop());
		}		
		if (x.size() % 2 != 0 ) {
			size = x.size() - 1;
		}else {
			size = x.size();
		}		
		while (i < size) {
			sum = x.pop() + x.pop();
			s.push(sum);
			i+=2;
		}		
		if (!x.isEmpty()) {
			s.push(x.pop());
		}
	}
	
	public static void reorder (Queue <Integer> q) {//orders the array from highest to lowest non-abs value
		Stack<Integer> x = new Stack <Integer>();
		int size = q.size(), i = 0,pos, negCount = 0;
		
		while (i < size) {//negetives in a temp stack 
			if (q.peek() < 0 ) {
				x.push(q.remove());
				negCount++;
			}else {
				q.add(q.remove());
			}
			i++;
		}
		while (!x.isEmpty()) {//place back in queue
			q.add(x.pop());
		}
		i = 0;
		pos = size - negCount;
		if (q.size() > 1) {
			while (q.peek() > 0 && i<pos) {//rearrange in the right order
				q.add(q.remove());
				i++;
			}
		}
			
	}
	
	public static void mirror (Stack <Integer> s) {//creates a mirror of the elements
		Queue <Integer> x = new LinkedList <Integer>();
		
		if (s == null) {
			throw new IllegalArgumentException();
		}
		int size = s.size();
		while (!s.isEmpty()) {//place in queue
			x.add(s.pop());
		}
		for (int z = 0; z < size; z++) {//duplicate
			s.add(x.peek());
			x.add(x.remove());
		}
		while (!s.isEmpty()) {//place in queue
			x.add(s.pop());
		}
		for (int z = 0; z < size; z++) {//reorder
			x.add(x.remove());
		}
		while (!x.isEmpty()) {//place in stack
			s.add(x.remove());
		}
	}
}
