

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HomeworkOne {
	public static void removeEvenLength (ArrayList <String> x) {
		int size = x.size();
		for (int i = 0; i <size; i++) {
			if (x.get(i).length() % 2 == 0) {
				x.remove(i);
			}
		}
	}
	
	public static int rangeBetweenZero (ArrayList <Integer> x) {
		int range=0, i1,i2;
		
		for (int i = 0; i < x.size(); i++) {
			if (x.get(i) == 0) {
				i1 = i;
				for (int z = x.size(); i > 0; i ++) {
					if (x.get(z) == 0) {
						i2 = z;
						range = i2 - i1;
						break;
					}else if (z == 0) {
						range = 1;
						break;
					}
				}
			}
		}
		
		return range;
	}
	
	public static void interleave (ArrayList <Integer> a1, ArrayList <Integer> a2) {
		ArrayList <Integer> temp = new ArrayList<>();
		int length;
		
		if (a1.size() < a2.size()) {
			length = a1.size();
		}else if (a1.size() > a2.size()) {
			length = a2.size();
		}else {
			length = a1.size();
		}
		
		for (int i = 0; i < length; i++ ) {
			if(i%2 != 0 || i == 0) {
				temp.add(a1.remove(i));
			}else {
				temp.add(a2.remove(i));
			}
		}
		
		if (!a1.isEmpty()) {
			temp.addAll(a1);
		}else if (!a2.isEmpty()) {
			temp.addAll(a2);
		}
		
		a1 = temp;
	}
	
	public static void collapse (Stack <Integer> s) {
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
	
	public static void reorder (Queue <Integer> q) {
		Stack<Integer> x = new Stack <Integer>();
		int size = q.size(), i = 0;
		
		while (i < size) {
			if (q.peek() < 0 ) {
				x.push(q.remove());
			}else {
				q.add(q.remove());
			}
			i++;
		}
		while (!x.isEmpty()) {
			q.add(x.pop());
		}
		while (q.peek() > 0) {
			q.add(q.remove());
		}
	}
	
	public static void mirror (Stack <Integer> s) {
		Queue <Integer> x = new LinkedList <Integer>();
		int size = s.size();
		
		if (s == null) {
			throw new IllegalArgumentException();
		}
		
		while (!s.isEmpty()) {
			x.add(s.pop());
		}
		for (int z = 0; z < size; z++) {
			s.add(x.peek());
			x.add(x.remove());
		}
		while (!s.isEmpty()) {
			x.add(s.pop());
		}
		for (int z = 0; z < size; z++) {
			x.add(x.remove());
		}
		while (!x.isEmpty()) {
			s.add(x.remove());
		}
	}
}
