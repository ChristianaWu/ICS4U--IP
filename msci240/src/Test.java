import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// create an empty array list with an initial capacity 
        ArrayList<Integer> arrlist = new ArrayList<Integer>(5); 
  
        // use add() method to add elements in the list 
        arrlist.add(10); 
        arrlist.add(22); 
        arrlist.add(30); 
        arrlist.add(40); 
        
        System.out.println(arrlist.get(3));
        
        // adding element 35 at fourth position 
        arrlist.add(3, 35); 
  
        // let us print all the elements available in list 
        for (Integer number : arrlist) { 
            System.out.println("Number = " + number);
        }

	}

}
