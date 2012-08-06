import java.util.Hashtable;

/**
 * Write a function f(a, b) which takes two character string arguments and
 * returns a string containing only the characters found in both strings in the
 * order of a. Write a version which is O(n)
 */
public class StringMatching {
	public static String LinearIntersection(String a, String b) {
		String result = "";

		// construct hash lookup table
		Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
		for (int i = 0; i < b.length(); i++) {
			hash.put("" + b.charAt(i), 1);
		}

		// construct output result string
		for (int i = 0; i < a.length(); i++) {
			char achar = a.charAt(i);
			// found in hash ie. string b, but not in result (part of a so far)
			// assume uniqueness ie. question only requires set of chars
			if (hash.containsKey("" + achar) && result.indexOf(achar) < 0) {
				result += achar;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(LinearIntersection("aaac", "babbadbc"));
	}
}
