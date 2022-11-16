package week_30;

import week_29.tree_review.MyTree;
import week_29.tree_review.MyTree_withAnswers;
import week_29.tree_review.Node;
import week_29.tree_review.VisualizeTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeApp_Week30 {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        MyTree_withAnswers myTree = new MyTree_withAnswers();
        int[] numbers = new int[]{10, 6, 4, 20};
        for (int each : numbers) {
            myTree.insert(each);
        }
        VisualizeTree.printTree(myTree.root, null, false);

        System.out.println("***************************");
        System.out.println(inOrderTraversalReturnList(myTree.root));
        System.out.println("***************************");
        System.out.println(inorderTraversalWithIterationReturnList(myTree.root));


    }

    public static List<Integer> inOrderTraversalReturnList(Node root) {
        if (root == null) return list;
        inOrderTraversalReturnList(root.leftChild);
        if (root != null)
            list.add(root.value);
        //System.out.print(root.value + ", ");
        inOrderTraversalReturnList(root.rightChild);
        return list;
    }

    public static List<Integer> inorderTraversalWithIterationReturnList(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.leftChild;
            } else {
                root = (Node) stack.pop();
                list.add(root.value);
                root = root.rightChild;
            }
        }
        return list;
    }
}
