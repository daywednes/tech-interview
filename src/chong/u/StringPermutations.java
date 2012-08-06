package chong.u;

/**
 * If you're past the last position
 * Print the string
 * Return
 * Otherwise
 * For each letter in the input string
 * If it's marked as used, skip to the next letter
 * Else place the letter in the current position
 * Mark the letter as used
 * Permute remaining letters starting at current position + 1
 * Mark the letter as unused
 */
public class StringPermutations {
	private static void permute(String str) {
		doPermute(str.toCharArray(), new StringBuffer(),
				new boolean[str.length()], str.length(), 0);
	}

	private static void doPermute(char[] in, StringBuffer out, boolean[] used,
			int length, int level) {
		// base case - fully used
		if (level == length) {
			System.out.println(out.toString());
			return;
		}

		// recursive case
		for (int i = 0; i < length; ++i) {
			if (used[i])
				continue;

			// The characters are appended to the StringBuffer as appropriate
			out.append(in[i]);
			used[i] = true;

			// recursive step
			doPermute(in, out, used, length, level + 1);
			used[i] = false;

			// the last character is dropped simply by reducing the bufferÕs
			// length
			out.setLength(out.length() - 1);
		}
	}

	public static void main(String[] args) {
		permute("hat");
	}
}
