public class reverseLL {
	private static ListNode reverse(ListNode head) {
		ListNode previous = null, current = head, next;
		// NULL head node1
		// [previous] [current] [next]
		while (current != null) {
			next = current.next; // set next to current's next
			current.next = previous; // set current's next to previous
			// update pointers
			previous = current; // advance previous to now be current
			current = next; // advance current to now be next
		}
		return previous; // this will be new head of the list
	}

	public static void main(String[] args) {
		// construct linked list cycle 5->2->0->6->3->1
		ListNode head = new ListNode(5)
		,	node1 = new ListNode(2)		
		,	node2 = new ListNode(0)
		,	node3 = new ListNode(6)
		,	node4 = new ListNode(3)
		,	node5 = new ListNode(1);

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		System.out.print("Original list: ");
		for (ListNode node = head; node != null; node = node.next) {
			System.out.print(node.value);
			if (node.next != null)
				System.out.print("->");
		}
		System.out.println();

		// reverse linked list
		head = reverse(head);

		System.out.print("Reversed list: ");
		for (ListNode node = head; node != null; node = node.next) {
			System.out.print(node.value);
			if (node.next != null)
				System.out.print("->");
		}
		System.out.println();
	}
}

class ListNode {
	Integer value = null;
	ListNode next;

	public ListNode(Integer num) {
		value = num;
	}
}