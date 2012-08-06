package chong.u;

public class ReverseWords {
	private static void reverseWords(char str[]) {
		int start = 0, end = 0, length = str.length;

		/* Reverse entire string */
		reverseString(str, start, length - 1);

		while (end < length) {
			if (str[end] != ' ') { /* Skip non-word characters */

				/* Save position of beginning of word */
				start = end; // save start of section of string to be reversed

				// find end of this section to be reversed
				/* Scan to next non-word character */
				while (end < length && str[end] != ' ')
					end++;
				/* Back up to end of word */
				end--;

				/* Reverse word */
				reverseString(str, start, end);
			}
			end++; /* Advance to next token */
		}
	}

	private static void reverseString(char str[], int start, int end) {
		while (end > start) {
			/* Exchange characters */
			if (str[start] != str[end]) {
				str[start] ^= str[end];
				str[end] ^= str[start];
				str[start] ^= str[end];
			}
			/* Move indices towards middle */
			start++;
			end--;
		}
	}

	/**
	 * Example 1: Write a function to reverse a string.
	 * general function
	 */
	public static String reverse(String s) {
		int length = s.length(), last = length - 1;
		char[] chars = s.toCharArray();
		for (int i = 0; i < length / 2; i++) {
			if (chars[i] != chars[last - i]) {
				chars[i] ^= chars[last - i];
				chars[last - i] ^= chars[i];
				chars[i] ^= chars[last - i];
			}
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		String s = "Do or do not, there is no try.";
		char[] sCharArray = s.toCharArray();
		
		reverseWords(sCharArray);
		System.out.println(sCharArray);

		System.out.println(reverse(s));
	}
}
