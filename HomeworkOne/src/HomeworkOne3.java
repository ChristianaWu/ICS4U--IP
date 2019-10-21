import java.util.ArrayList;

public class HomeworkOne3 {
	public static void removeEvenLength (ArrayList <String> x) {
		int i = 0;
		while (i < x.size()) {
			if(x.get(i).length() % 2 == 0) {
				x.remove(i);
				i--;
			}
			i++;
		}
	}
	
}
