
public class ListNodeMethods {

    // before:
    //    list -> 1 -> 2
    // after list = append(list, 3):
    //    list -> 1 -> 2 -> 3
    public static ListNode append(ListNode list, int value) {
    	list.next.next= new ListNode (value);
        return list;
    }
    
    // before:
    //    list -> 1 -> 2
    // after list = prepend(list, 3):
    //    list -> 3 -> 1 -> 2
    public static ListNode prepend(ListNode list, int value) {
        ListNode temp = new ListNode (3);
        temp.next = list;
        list = temp;
        return list;
    }
    
    // before:
    //   list -> 1 -> 2 -> 3
    //   temp -> 4 -> 5 -> 6
    // after:
    //   return list -> 5 -> 3 -> 4 -> 2
    public static ListNode rearrangeLists(ListNode list, ListNode temp) {
        ListNode x = temp.next.next;
        x.next = list.next.next.next;
        x.next.next = temp.next;
        x.next.next.next = list.next.next;
        list = x;
        return list;
    }
}
