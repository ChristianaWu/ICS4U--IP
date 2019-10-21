import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Meeting {
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		String in;
		ArrayList <String> inputValue = new ArrayList <> ();
		ArrayList <String> sch = new ArrayList <> ();
		String[][] courseList;
		
		in = input.nextLine();

		while (in.compareTo("exit") != 0) {	
			inputValue.add(in);
			in = input.nextLine();
		}
		
		courseList = new String [inputValue.size()][2];
		
		for (int row = 0; row < inputValue.size(); row++) {
			in = inputValue.get(row);
			int index = in.indexOf(" ");
			courseList [row][0] = in.substring(0, index);
			courseList [row][1] = in.substring(index);			
		}
		
		int i = 0;
		
		for (int row = 0; row < inputValue.size(); row++) {
			in = courseList [row][0];
			for (int row2 = 0; row2 < inputValue.size(); row2++) {
				if (in.compareTo(courseList [row][1]) == 0) {
					sch.add(in);
					i = row2;
					break;
				}
				i = row2;
			}
			
			if (i == inputValue.size()) {
				sch.add(0, in);
			}
		}
		
		int courseIndex = (sch.size()-1)/2;
		
		System.out.println(sch.get(courseIndex));
		
	}

}
