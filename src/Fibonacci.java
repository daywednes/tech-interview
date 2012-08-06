/**
 * Example 2: Write function to compute Nth fibonacci number:
 */
/**
   You have N steps to get down. You have two options
	a. either you come one step down (nth to (n-1)th )
	b. or you directly jump to the 3rd step leaving one step in between.
	( say from nth to (n-2)th )
   Find the total possible ways in which one can get down.

	Let F(n) defines the number of ways you can climb down n steps..
	Since you can either go one step and find F(n-1) or go two steps and find
	F(n-2)
	=> F(n) = F(n-1) + F(n-2)
	A fibonacci series
	Base case will be F(0) = 1 and F(1) = 1
	
	There are several way to compute n-th Finonacci number: recursive O(2^n),
	dynamic programming O(n) and using the formula F(n) = [phi ^ n / 2 - 1/2]
	where phi is the golden ratio : phi = (1 + sqrt(5))/2.
	To compute the n-th power of a number is O(log n) - treat cases when n is
	odd or even.
 */
public class Fibonacci {
	private static int[][] matrix = new int[][] { new int[] { 1, 0 },
			new int[] { 0, 1 } };
	private static int[][] matrix2 = new int[][] { new int[] { 1, 1 },
			new int[] { 1, 0 } };

	public static void main(String[] args) {
		System.out.println(fib(10));
		System.out.println(Fib(10));
		System.out.println(fibo(10));
	}

	// recursive solution - O(log n) time
	private static int fib(int n) {
		matrixpower(n - 1);
		return matrix[0][0];
	}

	private static void matrixpower(int n) {
		if (n > 1) {
			matrixpower(n / 2);
			multiply(matrix, matrix);
		}
		if (n % 2 == 1) // n is odd
		{
			multiply(matrix, matrix2);
		}
	}

	// multiply 2 matrices
	public static void multiply(int[][] m1, int[][] m2) {
		int m1rows = m1.length;
		int m1cols = m1[0].length;
		int m2rows = m2.length;
		int m2cols = m2[0].length;
		if (m1cols != m2rows)
			throw new IllegalArgumentException("matrices don't match: "
					+ m1cols + " != " + m2rows);
		int[][] result = new int[m1rows][m2cols];

		// multiply
		for (int i = 0; i < m1rows; i++)
			for (int j = 0; j < m2cols; j++)
				for (int k = 0; k < m1cols; k++)
					result[i][j] += m1[i][k] * m2[k][j];

		matrix = result;
	}

	// closed form solution
	private static int Fib(int N) {
		double sqrt5 = Math.sqrt(5);
		double phi = (1 + sqrt5) / 2.0;
		double fn = (Math.pow(phi, N) - Math.pow(1 - phi, N)) / sqrt5;
		return (int) fn;
	}

	// recursive one-liner
	private static long recFib(int n) {
		return n <= 1 ? n : recFib(n - 1) + recFib(n - 2);
	}

	// tail recursive version
	private static int fibonacci(int n, int i, int k) {
		if (i <= n) {
			return fibonacci(n, i + 1, k + i);
		} else {
			return k;
		}
	}

	private static int fibo(int n) {
		return fibonacci(n, 1, 0);
	}
}
