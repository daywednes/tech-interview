package pc;
/*
 * Problem ID#110101
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.io.IOException;

class myStuff implements Runnable {
	public void run() {
		// Your program here
		String input = null;
		while ((input = Main.ReadLn(1024)) != null) {
			String[] array = input.trim().split("\\s+", 2);
			int i = Integer.parseInt(array[0]), j = Integer.parseInt(array[1]);

			if (i > j) {	// XOR swap fails with i == j
				// swap values
				i ^= j;
				j ^= i;
				i ^= j;
			}

			int maxCycle = 0;
			for (int count = i; count <= j; count++) {
				long n = count;
				int cycle = 0;
				while (n != 1) {
					cycle++;
					if (n % 2 == 0)
						n /= 2;
					else
						n = 3 * n + 1;
				}
				maxCycle = Math.max(maxCycle, ++cycle);
			}
			System.out.println(array[0] + " " + array[1] + " " + maxCycle);
		}
	}

	// You can insert more classes here if you want
}

class Main implements Runnable {
	static String ReadLn(int maxLength) { // utility function to read from
											// stdin,
											// Provided by
											// Programming-challenges, edit for
											// style only
		byte line[] = new byte[maxLength];
		int length = 0;
		int input = -1;
		try {
			while (length < maxLength) { // Read until maxlength
				input = System.in.read();
				if ((input < 0) || (input == '\n'))
					break; // or until end of line input
				line[length++] += input;
			}

			if ((input < 0) && (length == 0))
				return null; // eof
			return new String(line, 0, length);
		} catch (IOException e) {
			return null;
		}
	}

	public static void main(String args[]) // entry point from OS
	{
		Main myWork = new Main(); // Construct the bootloader
		myWork.run(); // execute
	}

	public void run() {
		new myStuff().run();
	}
}
