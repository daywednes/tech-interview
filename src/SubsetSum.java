/**
 * Why does it work? because if we went from he lowest sum till now to the
 * highest sum till now this is the biggest different of the numbers in the
 * summary therefore this numbers sum would be the largest in the list.
 */
// runtime complexity - O(n)
public class SubsetSum {
	public static void main(String[] args) {
		int[] nums = new int[] { -7, 12, -5, 13, -2 };

		// generate sequential sum
		int[] seqSum = findSeqSum(nums);

		// find min/max + associated indices
		int min = -1, max = -1, indexOfMin = -1, indexOfMax = -1;
		for (int i = 0; i < seqSum.length; ++i) {
			// found new min
			if (min >= seqSum[i]) {
				min = seqSum[i];
				indexOfMin = i;
			}

			// found new max
			if (max <= seqSum[i]) {
				max = seqSum[i];
				indexOfMax = i;
			}
		}

		// print answer
		if (indexOfMin + 1 >= indexOfMax) {
			for (int i = 0; i <= indexOfMax; ++i)
				System.out.println(nums[i]);
		} else {
			for (int i = indexOfMin + 1; i <= indexOfMax; ++i)
				System.out.println(nums[i]);
		}
	}

	private static int[] findSeqSum(int[] input) {
		int[] result = new int[input.length];
		int runningTotal = 0;
		for (int i = 0; i < input.length; ++i) {
			runningTotal += input[i];
			result[i] = runningTotal;
		}
		return result;
	}
}
