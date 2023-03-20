package week_12_SQL;

import java.util.HashSet;

public class LinkedListCycle {
    /*
    141. Linked List Cycle
    Easy
    Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

Follow up: Can you solve it using O(1) (i.e. constant) memory?

https://leetcode.com/problems/linked-list-cycle/
     */

    ListNode head;
    ListNode tail;


    public static void main(String[] args) {
        LinkedListCycle list = new LinkedListCycle();
        list.add(3);
        list.add(2);
        list.add(0);
        list.add(-4);
        list.tail.next = list.head.next;
        System.out.println("list.twoPointer(list.head) = " + list.twoPointer(list.head));
        System.out.println("list.hashSet(list.head) = " + list.hashSet(list.head));

    }

    public boolean twoPointer(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }
        return false;
    }


    public boolean hashSet(ListNode head) {
        if (head == null) return false;
        ListNode current = head;
        HashSet<ListNode> set = new HashSet<>();
        while (current != null) {
            if (!set.add(current)) return true;
            current = current.next;
        }
        return false;
    }


    public ListNode add(int value) {
        ListNode node = new ListNode(value);
        if (head == null) {
            head = tail = node;
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        tail = node;
        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "  ");
            current = current.next;
        }
        System.out.println();
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
