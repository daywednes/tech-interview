/**
 * Find minimum number in a circular list
 * 
 * You are given a list of numbers. When you reach the end of the list you will
 * come back to the beginning of the list (a circular list). Write the most
 * efficient algorithm to find the minimum # in this list. Find any given # in
 * the list. The numbers in the list are always increasing but you don’t know
 * where the circular list begins, ie: 38, 40, 55, 89, 6, 13, 20, 23, 36.
 * 
 * Steps:
 * ===============
 * input : Pointer to a node in a circular list
 * output: The minimum value in the list
 * Create a temp pointer and assign the input node to it
 * (since the list is circular, we need to maintain the start pointer to
 * identify the start of the list)
 * Maintain a minimum number variable
 * Compare every element with the min variable and replace the value if
 * current number is lesser than min
 * if current node is start node – exit loop
 * return the min value
 * 
 */
public class minCircularList {
	private static int findMinimum(Node start) {
		int min = start.data;
		Node t = start.link;
		while (t != start) {
			if (t.data < min)
				min = t.data;
			t = t.link;
		}
		return min;
	}

	private static class Node {
		int data;
		Node link;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node nine  = new Node(36);
		Node eight = new Node(23);
		Node seven = new Node(20);
		Node six   = new Node(13);
		Node five  = new Node(6);
		Node four  = new Node(89);
		Node three = new Node(55);
		Node two   = new Node(40);
		Node one   = new Node(38);
		
		one.link = two;
		two.link = three;
		three.link = four;
		four.link = five;
		five.link = six;
		six.link = seven;
		seven.link = eight;
		eight.link = nine;	
		nine.link = one;

		System.out.println(findMinimum(five));
	}
}
