package chong.u;

// runtime complexity O(n + m)
public class RemoveSpecifiedChar {
	private static String removeChars(String str, String remove) {
		boolean[] bitset = new boolean[128]; // ASCII are 7-bit

		// initialize array
		/**
		 * Because the size of a character is fixed for a given platform,
		 * zeroing the array is constant time - O(1)
		 */
		for (int i = 0; i < bitset.length; ++i)
			bitset[i] = false;

		/**
		 * building lookup array is O(m)
		 */
		for (int i = 0; i < remove.length(); ++i)
			bitset[(int) remove.charAt(i)] = true;

		/**
		 * Finally, you do at most one constant time lookup and one constant
		 * time copy for each character in str, giving O(n) for this stage.
		 */
		int dst = 0;
		char[] s = new char[str.length()];
		for (int i = 0; i < str.length(); ++i) {
			if (!bitset[(int) str.charAt(i)]) {
				s[dst++] = str.charAt(i);
			}
		}

		return new String(s, 0, dst);
	}

	public static void main(String[] args) {
		System.out.println(removeChars(
				"Battle of the Vowels: Hawaii vs. Grozny", "aeiou"));
	}
}
