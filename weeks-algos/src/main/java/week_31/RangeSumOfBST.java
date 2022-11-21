package week_31;

import java.util.Stack;

public class RangeSumOfBST {



    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(18);

        System.out.println(rangeSumBST(root,7,15));
        System.out.println(recursive(root,7,15));

    }

    public static int rangeSumBST(Node root, int low, int high) {
        int ans = 0;
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) {
                if (low <= node.val && node.val <= high)
                    ans += node.val;
                if (node.val > low)
                    stack.push(node.left);
                if (node.val < high)
                    stack.push(node.right);
            }
        }
        return ans;
    }





    private static int answer;
    public static int recursive(Node root, int low, int high) {
        answer = 0;
        dfs(root, low, high);
        return answer;
    }

    public static void dfs(Node node, int low, int high) {
        if (node != null) {
            if (low <= node.val && node.val <= high)
                answer += node.val;
            if (node.val > low)
                dfs(node.left, low, high);
            if (node.val < high)
                dfs(node.right, low, high);
        }
    }



    static class Node {
        int val;
        Node left;
        Node right;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
