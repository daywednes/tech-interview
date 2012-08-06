/**
 * Write code to find whether a given binary tree is mirror image of itself?
 */
public class BinaryTree {
	private static boolean isMirrorImage(Node n1, Node n2) {
		if (n1 == null && n2 == null)
			return true;
		else if (n1 == null || n2 == null)
			return false;
		else if (n1.val != n2.val)
			return false;

		return isMirrorImage(n1.left, n2.right)
				&& isMirrorImage(n1.right, n2.left);
	}
	
	private static class Node {
		Node left, right;
		int val;
	}
}
