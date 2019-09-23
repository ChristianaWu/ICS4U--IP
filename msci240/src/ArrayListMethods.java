import java.util.ArrayList;

public class ArrayListMethods {
/*
 * 	public static void main(String[] args){

		ArrayList <Integer> al = new ArrayList<> (1);
		al.add(12);

		
		minToFront(al);
	} */
	
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
