/**
 * Find a pair of numbers from an array whose sum equals N
 * Let A be an array of random integers. User gives N which can be any integer
 * and the program has to return a pair of numbers from array whose sum = N
 * eg. A = {3,6,1,9,6,5};
 * Let N = 10 then your program should return 1,9. In case of many pairs,
 * return first pair. Try to make this as fast as possible, please specify the
 * complexities also.
 */
/* O(n) solution using bin sort */
public class BitSum {
	private static void findCombinations(int[] array, int sum) {
		// assume only natural numbers
		boolean[] flags = new boolean[sum];
		// initialize bitmap
		for (int i = 0; i < flags.length; ++i)
			flags[i] = false;

		// construct lookup table
		for (int i = 0; i < array.length; ++i)
			flags[array[i]] = true;

		for (int i = 0; i <= flags.length / 2; ++i) {
			if (flags[i] && flags[sum - i])
				System.out.printf("sum of %d and %d\n", i, sum - i);
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 3, 6, 1, 9, 6, 5 };
		findCombinations(a, 10);
	}
}
