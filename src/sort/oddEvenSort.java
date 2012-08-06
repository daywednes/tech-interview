package sort;
/**
 * Google phone screening 25 Nov 2010 10am
 * Write a function to sort a given
 * integer array with odd numbers first,
 * then followed by even numbers
 */
public class oddEvenSort {
	public void inPlaceSort(int[] input) {
		// bubble sort algorithm - loop n^2 times
		for (int i = 0; i < input.length; i++)
			for (int j = 0; j < input.length - 1; j++) {
				if (input[j] % 2 == 0 && input[j + 1] % 2 == 1) {
					int pos1 = j, pos2 = j + 1;
					// XOR swap does not work if elements are equal
					if (input[pos1] != input[pos2])
					{
						input[pos1] ^= input[pos2];
						input[pos2] ^= input[pos1];
						input[pos1] ^= input[pos2];
					}
				}
			}
	}

	public static void main(String[] args) {
		oddEvenSort r = new oddEvenSort();
		int[] in = { 1, 2, 3, 7, 5, -2, -6, 100, 50000, 17, 25, 25, 16, 14 };
		
		System.out.print("Original array: ");
		for (int i = 0; i < in.length; i++) {
			System.out.print(in[i]);
			if (i + 1 < in.length)
				System.out.print(", ");
		}
		System.out.println();
		
		r.inPlaceSort(in);
		
		System.out.print("Sorted array: ");
		for (int i = 0; i < in.length; i++) {
			System.out.print(in[i]);
			if (i + 1 < in.length)
				System.out.print(", ");
		}
		System.out.println();
	}
}