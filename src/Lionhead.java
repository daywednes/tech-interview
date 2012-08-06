public class Lionhead {
	public static void main(String[] args) {
		int[] A = { 0, 1, 2, 3, 4 };
		for (int k = 0; k < 5; k++)
			A[k] = A[A[k]];
		for (int k = 0; k < 5; k++)
			System.out.println(A[k]);
	}
}