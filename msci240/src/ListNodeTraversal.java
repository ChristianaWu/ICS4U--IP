
public class ListNodeTraversal {

    // before:
    //   list -> 7 -> ... -> 16
    // after list = changeAllValues(list, 42):
    //   list -> 42 -> ... -> 42
    public static ListNode changeAllValues(ListNode list, int value) {
    	ListNode current = list;
        while (current != null) {
        	current.data = value;
        	current = current.next;
        }
        return list;
    }

    // before:
    //   list -> 7 -> ... -> 3
    // after list = changeLast(list, 42):
    //   list -> 7 -> ... -> 42
    public static ListNode changeLast(ListNode list, int value) {
    	ListNode current = list;
        while (current != null) {
        	current = current.next;
        	if (current.next == null) {
        		current.data = value;
        	}
        }
        return list;
    }

    // before:
    //   list -> 7 -> ... -> 3
    // after list = append(list, 42):
    //   list -> 7 -> ... -> 3 -> 42
    public static ListNode append(ListNode list, int temp) {
        ListNode current = list;
        ListNode x = new ListNode (temp);
        
        while (current != null) {
        	current = current.next;
        	if (current.next == null) {
        		current.next = x;
        	}
        }
        return list;
    }
}
