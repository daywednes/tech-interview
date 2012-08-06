package chong.u;

import java.util.Stack;

public class TreeTraversal
{
    /* recursive */
    // every node is examined once - O(n)
    private static void recPreOrder(BSTNode start)
    {
        if (start == null) return;
        System.out.println(start.value);
        recPreOrder(start.left);
        recPreOrder(start.right);
    }

    private static void recInOrder(BSTNode start)
    {
        if (start == null) return;
        recInOrder(start.left);
        System.out.println(start.value);
        recInOrder(start.right);
    }

    private static void recPostOrder(BSTNode start)
    {
        if (start == null) return;
        recPostOrder(start.left);
        recPostOrder(start.right);
        System.out.println(start.value);
    }

    /* iterative */
    // each node is examined only once and pushed on the stack only once
    // so still O(n)
    private static void preOrder(BSTNode root)
    {
        Stack<BSTNode> al = new Stack<BSTNode>();
        al.add(root);

        while (!al.isEmpty()) {
            BSTNode node = al.pop();
            if (node != null) System.out.println(node.value);
            if (node.right != null) al.push(node.right);
            if (node.left != null) al.push(node.left);
        }
    }

    public static void main(String[] args)
    {
        BSTNode root = new BSTNode(100);
        BSTNode one = new BSTNode(50);
        BSTNode two = new BSTNode(25);
        BSTNode three = new BSTNode(75);
        BSTNode four = new BSTNode(150);
        BSTNode five = new BSTNode(125);
        BSTNode six = new BSTNode(175);
        BSTNode seven = new BSTNode(110);

        five.left = seven;
        four.left = five;
        four.right = six;
        one.left = two;
        one.right = three;
        root.left = one;
        root.right = four;

        preOrder(root);
    }

    private static class BSTNode
    {
        BSTNode left, right;
        int value;

        public BSTNode(int value)
        {
            this.value = value;
        }
    }
}
