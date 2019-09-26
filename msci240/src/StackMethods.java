import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackMethods {
	public static void splitStack (Stack<Integer> st){
		Queue <Integer> q1 = new LinkedList<> ();
		
		while (!st.isEmpty()) {
			q1.add(st.pop());
		}
		
		int i = 0;
		
		while (i < q1.size()) {
			if (q1.peek() < 0) {
				st.push(q1.remove());
			}else {
				q1.add(q1.remove());
			
			}
		}
		
		while (!q1.isEmpty()) {
			st.add(q1.remove());
		}
		
	}
}
