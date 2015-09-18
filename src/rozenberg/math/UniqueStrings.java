package rozenberg.math;

import java.util.HashSet;

public class UniqueStrings {

	public static void main(String[] args) {

		String array[] = new String[] { "A", "A", "B", "B", "B", "C" };
		// for loops (1) fist goes through away (2) next goes through checking
		// to see if there are duplicates
		// do novice answer

		/*
		 * for (int i=0; i<array.length;i++){ boolean found = false; for (int
		 * j=0;j<i;j++){ if (array[i].equals(array[j]) ) { found = true; } } if
		 * (!found){ System.out.println(array[i]); } }
		 */

		HashSet<String> set = new HashSet<String>(); // go through the array
		for (String s : array) { // if String is not in the set
			if (!set.contains(s)) {
				System.out.println(s);
			}
			set.add(s); // add it }
		}
	}
}
