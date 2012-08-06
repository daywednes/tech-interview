public class test {
	// computes in O(log n) time
	private static int power(int a, int n) {
		int i = 0;
		int total = 1;

		while (i <= n) {
			total = total * a;
			i++;
		}

		return total;
	}

	public static void main(String[] args) {

	}
}
