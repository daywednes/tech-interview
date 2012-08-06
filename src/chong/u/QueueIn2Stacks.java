package chong.u;

import java.util.Stack;

/* iterative implementation */
// amortized runtime of O(n)
/**
 * amortized analysis finds the average running time per operation over a
 * worst-case sequence of operations. Amortized analysis differs from
 * average-case performance in that probability is not involved; amortized
 * analysis guarantees the time per operation over worst-case performance
 */
public class QueueIn2Stacks {
	private Stack<Integer> in = new Stack<Integer>(),
			out = new Stack<Integer>();

	private void enqueue(int num) {
		while (!out.isEmpty()) {
			in.push(out.pop());
		}
		in.push(num);
	}

	private int dequeue() {
		while (!in.isEmpty()) {
			out.push(in.pop());
		}
		return out.pop();
	}

	public static void main(String[] args) {
		QueueIn2Stacks q = new QueueIn2Stacks();
		System.out.print("Enqueue: {");
		for (int i = 1; i <= 10; ++i) {
			q.enqueue(i);
			System.out.print(i);
			if (i < 10)
				System.out.print(",");
		}
		System.out.println("}");

		System.out.print("Dequeue: {");
		for (int i = 1; i <= 10; ++i) {
			System.out.print(q.dequeue());
			if (i < 10)
				System.out.print(",");
		}
		System.out.println("}");
	}
}
