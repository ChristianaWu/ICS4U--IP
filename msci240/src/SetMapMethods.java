import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SetMapMethods {
	public static int maxLength (Set<String> s) {
		int length = 0;
		if (!s.isEmpty()) {
			for (String word: s) {
				if (word.length() > length) {
					length = word.length();
				}
			}
		}
		return length;
	}
	
	public static int maxOccurrences (List<Integer> l) {
		int mode = 0;
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		if (!l.isEmpty()) {
			for (int i = 0 ; i < l.size(); i++) {
				int numb = l.get(i);
				if (!m.containsKey(numb)) {
					m.put(numb, 1);
				}else {
					int value = m.get(numb) + 1;
					m.put(numb, value);
				}
			}
		}
		
		for (Integer values: m.values()) {
			if (values > mode) {
				mode = values;
			}
		}
		return mode;
	}
}
