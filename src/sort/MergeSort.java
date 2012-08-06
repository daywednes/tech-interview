package sort;

public class MergeSort {
	private static int[] a, b; // auxiliary array b

	public static void main(String[] args) {
		int[] nums = new int[] { -404, 139, -310, -114, 167, -28, 458, -96,
				451, -166, -434 };
		sort(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}

	private static void sort(int[] a0) {
		a = a0;
		int n = a.length;
		b = new int[(n + 1) / 2];
		mergesort(0, n - 1);
	}

	private static void mergesort(int lo, int hi) {
		if (lo < hi) {
			int m = (lo + hi) / 2;
			mergesort(lo, m);
			mergesort(m + 1, hi);
			merge(lo, m, hi);
		}
	}

	private static void merge(int lo, int m, int hi) {
		int i, j, k;

		i = 0;
		j = lo;
		// copy first half of array a to auxiliary array b
		while (j <= m)
			b[i++] = a[j++];

		i = 0;
		k = lo;
		// copy back next-greatest element at each time
		while (k < j && j <= hi) {
			if (b[i] % 2 == 1) /* custom comparator function - odd goes left */
		// if (b[i] <= a[j])
				a[k++] = b[i++];
			else
				a[k++] = a[j++];
		}

		// copy back remaining elements of first half (if any)
		while (k < j)
			a[k++] = b[i++];
	}
}