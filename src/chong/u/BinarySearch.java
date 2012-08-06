package chong.u;

import java.util.Random;

// runtime complexity O(log n)
// array is initially sorted
public class BinarySearch {
	// returns index of element if found, o/w -1
	private static int bSearch(int[] a, int x) {
		int low = 0, mid, high = a.length - 1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (x > a[mid])
				low = mid + 1;
			else if (x < a[mid])
				high = mid - 1;
			else
				return mid;
		}
		return -1; // NOT_FOUND
	}

	public static void main(String[] args) {
		int[] r = new int[128];
		for (int i = 0; i < r.length; i++) {
			r[i] = new Integer(i * 2);
			System.out.print(r[i]);
			if (i + 1 < r.length)
				System.out.print(", ");
		}
		System.out.println();

		Random rnd = new Random();
		int no = rnd.nextInt(r.length * 2);
		int index = bSearch(r, no);
		if (index > -1)
			System.out.println("Found " + no + " at index " + index);
		else
			System.out.println(no + " not found");
	}
}
