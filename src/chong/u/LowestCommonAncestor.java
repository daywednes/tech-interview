package chong.u;

// runtime complexity: O(log n)
public class LowestCommonAncestor {
	private static BSTNode findIt(BSTNode node, int num1, int num2) {
		while (node != null) {
			if (node.value > num1 && node.value > num2)
				node = node.left;
			else if (node.value < num1 && node.value < num2)
				node = node.right;
			else
				return node;
		}
		return null;
	}

	public static void main(String[] args) {
		BSTNode root = new BSTNode(20);
		BSTNode one = new BSTNode(8);
		BSTNode two = new BSTNode(4);
		BSTNode three = new BSTNode(12);
		BSTNode four = new BSTNode(10);
		BSTNode five = new BSTNode(14);
		BSTNode six = new BSTNode(22);

		three.left = four;
		three.right = five;
		one.left = two;
		one.right = three;
		root.left = one;
		root.right = two;

		System.out.println(findIt(root, 4, 14).value);
	}

	private static class BSTNode {
		BSTNode left, right;
		int value;

		public BSTNode(int value) {
			this.value = value;
		}
	}
}
