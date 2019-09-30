import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackMethods {
	public static void splitStack (Stack<Integer> st){
		Queue <Integer> q1 = new LinkedList<Integer> ();
		
		q1.addAll(st);
		st.clear();
		
		int i = 0;
		int size = q1.size();
		
		while (i < size) {
			if (q1.peek() < 0) {
				st.push(q1.remove());
			}else {
				q1.add(q1.remove());
			
			}
			
			i++;
		}
		
		while (!q1.isEmpty()) {
			st.add(q1.remove());
		}
		
	}
}
