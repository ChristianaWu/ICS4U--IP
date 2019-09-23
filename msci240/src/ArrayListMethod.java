import java.util.ArrayList;

public class ArrayListMethod {
	public static void test () {
		ArrayList <Integer> al = new ArrayList<> (5);
		al.add(12);
		al.add(15);
		al.add(3);
		al.add(16);
		al.add(17);
		
		minToFront(al);
	}
	public static void minToFront (ArrayList<Integer> al) {
			Integer low= al.get(0);
			int index = 0;
			
			for (int i = 1; i <al.size(); i++) {
				if (low > al.get(i)) {
					low = al.get(i);
					index = i;
				}
			}
			
			al.remove(index);
			al.add(0, low);
			
			System.out.println(al.toString());
	}
}
