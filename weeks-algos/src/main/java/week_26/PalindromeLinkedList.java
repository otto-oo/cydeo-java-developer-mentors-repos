package week_26;

import java.util.Stack;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        //for positive scenario
        Node head1 = new Node(1);
        Node node1 = new Node(8);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(3);
        Node node5 = new Node(8);
        Node node6 = new Node(1);
        head1.next = node1;
        head1.next.next = node2;
        head1.next.next.next = node3;
        head1.next.next.next.next = node4;
        head1.next.next.next.next.next = node5;
        head1.next.next.next.next.next.next = node6;
        head1.print();
        //call isPalindromeWithStack method
        System.out.println(isPalindromeWithStack(head1));

        //for negative scenario
        Node head2 = new Node(5);
        Node node7 = new Node(6);
        Node node8 = new Node(7);
        Node node9 = new Node(3);
        Node node10 = new Node(2);
        Node node11 = new Node(1);
        head2.next = node7;
        head2.next.next = node8;
        head2.next.next.next = node9;
        head2.next.next.next.next = node10;
        head2.next.next.next.next.next = node11;
        head2.print();
        //call isPalindromeWithStack method
        System.out.println(isPalindromeWithStack(head2));

        System.out.println("Test the ***isPalindromeWithTwoPointer*** method");

        //call isPalindromeWithTwoPointer method for positive scenario
        System.out.println(isPalindromeWithTwoPointer(head1));

        //call isPalindromeWithTwoPointer method for negative scenario
        System.out.println(isPalindromeWithTwoPointer(head2));
    }

    public static boolean isPalindromeWithStack(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node current = head;
        while (current != null) {
            stack.push(current.value);
            current = current.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromeWithTwoPointer(Node head) {

        Node slow = head, fast = head;

        // find middle point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse 2nd half of linked list

        Node prev = null, temp;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // palindrome check : first half and second half
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.value != slow.value) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;

    }

}

class Node {

    public Node next;
    public int value;

    public Node(int value) {
        this.value = value;
    }

    public void print() {
        Node current = this;

        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}