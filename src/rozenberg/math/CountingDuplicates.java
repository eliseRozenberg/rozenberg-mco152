package rozenberg.math;

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicates {
	public static void main(String[] args) {
		String[] array = new String[] { "A", "A", "B", "C", "F", "F", "G", "B",
				"C", "Z" };
		Map<String, Integer> map = new HashMap<String, Integer>();

		// fill the HashMaps
		for (String key : array) {
			//int or integer?
			Integer value = map.get(key);
			if (value == null) {
				map.put(key, 1);
			} else {
				map.put(key, value + 1);
			}
		}

		// iterate through the HashMap's key-value pairs
		//entry set?
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
}
