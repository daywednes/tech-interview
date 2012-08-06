public class Garbage {
	private static class Blah {
		public void finalize() {
			System.out.println("finalizing!");
		}
	}

	private static void f() throws Throwable {
		Blah blah = new Blah();
		blah.finalize();
	}

	public static void main(String[] args) throws Throwable {
		System.out.println("start");
		f();			// manually invoke finalize
		System.gc();	// get JVM to finalize
		System.out.println("done");
	}
}
