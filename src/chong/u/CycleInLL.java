package chong.u;
import junit.framework.TestCase;

// runtime complexity: O(n)
/**
 * acyclic: examine 3/2n nodes = n + 0.5n
 * cyclic: examine 3n nodes in total
 */
public class CycleInLL extends TestCase {
	private Node head, node2, node5;

	/**
	 * implements Floyd's cycle-finding algorithm
	 * also called "The Tortoise and the Hare Algorithm"
	 * Takes a pointer to the head of a linked list and determines if
	 * the list ends in a cycle or is NULL terminated
	 */
	private static boolean hasCycle(Node start) {
		if (start == null) {
			return false;
		}
		Node turtle = start; // slower moving node
		Node rabbit = start.next; // faster moving node
		while (rabbit != null) {
			if (rabbit.equals(turtle)) {
				// the faster moving node has caught up
				// with the slower moving node
				return true;
			} else if (rabbit.next == null) {
				// reached the end of list
				return false;
			} else {
				turtle = turtle.next;
				rabbit = rabbit.next.next;
			}
		}
		// rabbit reached the end
		return false;
	}

	public void setUp() {
		// construct linked list cycle 5->(2)->0->6->3->1(->2)
		head = new Node(5);
		Node node1 = new Node(2);
		node2 = new Node(0);
		Node node3 = new Node(6);
		Node node4 = new Node(3);
		node5 = new Node(1);

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
	}

	public void testCycle() {
		assertFalse("before: list has cycle", hasCycle(head));
		node5.next = node2; // create cycle
		assertTrue("after: list does not have cycle", hasCycle(head));
	}

	public void tearDown() {
	}

	private static class Node {
		Node next;
		int value;

		public Node(int num) {
			value = num;
		}
	}
}
