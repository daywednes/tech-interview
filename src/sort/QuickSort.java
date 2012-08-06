package sort;

public class QuickSort {
	private static void quicksort(int[] a, int lo, int hi) {
		// lo is the lower index, hi is the upper index
		// of the region of array a that is to be sorted
		int i = lo, j = hi;

		// comparison element x
		int x = a[(lo + hi) / 2];

		// partition
		do {
			while (a[i] < x)
				i++;
			while (a[j] > x)
				j--;
			if (i <= j) {
				// XOR swap does not work when a[i] == a[j]
				if (a[i] != a[j]) {
					a[i] ^= a[j];
					a[j] ^= a[i];
					a[i] ^= a[j];
				}
				i++;
				j--;
			}
		} while (i <= j);

		// recursion
		if (lo < j)
			quicksort(a, lo, j);
		if (i < hi)
			quicksort(a, i, hi);
	}

	public static void main(String[] args) {
		int[] array = { 3, 5, -2, 4, 0, -1, -7, 6 };
		quicksort(array, 0, array.length - 1);

		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i]);
			if (i + 1 < array.length)
				System.out.print(", ");
		}
		System.out.println();
	}
}