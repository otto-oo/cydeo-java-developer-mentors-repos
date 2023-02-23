package week_14_TicketingORMpart1;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeLinkedList {
    /*
    234. Palindrome Linked List
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false

Constraints:
    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?
     */

    public static void main(String[] args) {
        //for positive scenario
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(6);
        head1.next.next.next.next = new ListNode(3);
        head1.next.next.next.next.next = new ListNode(8);
        head1.next.next.next.next.next.next = new ListNode(1);

        System.out.println("positive scenario : " );
        print(head1);
        System.out.println(withTwoPointer(head1));

        //for negative scenario
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(7);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(2);
        head2.next.next.next.next.next = new ListNode(1);

        System.out.println("negative scenario : " );
        print(head2);
        System.out.println(withTwoPointer(head2));
    }

    static boolean withStackSimple(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode current = head;

        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        current = head;
        // it compares all nodes twice
        while (current != null) {
            if (current.val != stack.pop())
                return false;
            current = current.next;
        }
        return true;
    }

    static boolean withStackAdvanced(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode current = head;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        current = head;
        ListNode prev = null;
        // it compares each node once.
        // we need to keep previous if linkedlist size is even number
        while (current != stack.peek() && prev != stack.peek()) {
            if (current.val != stack.pop().val) return false;
            prev = current;
            current = current.next;
        }
        return true;
    }

    static boolean withTwoPointer(ListNode head) {
        ListNode slow = head, fast = head, prev, nextNode, current;
        // find middle point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse 2nd half of linked list
        prev = slow;
        current = slow.next;
        prev.next = null;   // we break the reverse cycle and avoid an endless loop.
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // palindrome check : first half and second half
        ListNode left = head;
        ListNode right = prev;
        while (left != null && right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
