package rozenberg.math;

import java.util.HashSet;

public class ShowDuplicates {
	public static void main(String[] args) {
		// use a data structure
		// SET- is an unordered group of objects that can have no duplicates
		// Hash Set Class- more efficient than an arrayList- see
		// ScrabbleDictionary
		// if not contained in the set- print it out- then add it to the set
		// an array is unordered- while the set is not guaranteed- can be
		// returned in any order
		String[] array = new String[] { "A", "A", "B", "C", "F", "F", "G", "B", "C", "Z" };
		HashSet<String> uniqueSet = new HashSet<String>();
		HashSet<String> printSet = new HashSet<String>();
		// go through the array
		for (String s : array) {
			if (uniqueSet.contains(s) && (!printSet.contains(s))) {
				System.out.println(s);
				printSet.add(s);
			} else if (!uniqueSet.contains(s)) {
				uniqueSet.add(s);
			}

		}
	}
}
// finish code
