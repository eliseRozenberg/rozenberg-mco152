package rozenberg.ufo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class ValueComparator implements Comparator<String> {
	Map<String, Integer> map;

	public ValueComparator(HashMap<String, Integer> map) {
		this.map = map;
	}

	public int compare(String a, String b) {
		if (map.get(a) >= map.get(b)) {
			return -1;
		} else {
			return 1;
		} // returning 0 would merge keys
	}
}