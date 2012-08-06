package chong.u;

public class IntegerStringConvert {
	/**
	 * Start number at 0
	 * If the first character is '-'
	 * Set the negative flag
	 * Start scanning with the next character
	 * For each character in the string
	 * Multiply number by 10
	 * Add (digit character Ð '0') to number
	 * Return number
	 */
	private static int strToInt(String str) {
		int i = 0, num = 0;
		boolean isNegative = false;

		// check for negative
		if (str.charAt(0) == '-') {
			isNegative = true;
			i = 1;
		}

		// scan string char-by-char
		while (i < str.length()) {
			num *= 10;
			num += str.charAt(i++) - '0';
		}

		// cater for negatives
		if (isNegative)
			num *= -1;

		return num;
	}

	/**
	 * If number less than zero:
	 * Multiply number by Ð1
	 * Set negative flag
	 * While number not equal to 0
	 * Add '0' to number % 10 and write this to temp buffer
	 * Integer divide number by 10
	 * If negative flag is set
	 * Write '-' into next position in temp buffer
	 * Write characters in temp buffer into output string in reverse order:
	 */
	public static final int MAX_DIGITS = 10;
	private static String intToStr(int num) {
		int i = 0;
		boolean isNegative = false;
		/* Buffer big enough for largest int and - sign */
		char[] output = new char[MAX_DIGITS + 1];
		
		// check for negatives
		if (num < 0)
		{
			num *= -1;
			isNegative = true;
		}
		
		// fill buffer with digits in reverse order
		while (num != 0)
		{
			output[i++] = (char) (num % 10 + '0');
			num /= 10;
		}
		
		// prepare output
		StringBuffer b = new StringBuffer();
		// cater for negatives
		if (isNegative)
			b.append('-');
		// append in reverse order
		while(i>0)
			b.append(output[--i]);

		return b.toString();
	}

	public static void main(String[] args) {
		System.out.println(strToInt("-372"));
		System.out.println(intToStr(-1234567890));
	}
}
