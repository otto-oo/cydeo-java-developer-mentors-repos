package week_12_SQL;

import java.util.HashSet;

public class LinkedListCycle_II {
/*
142. Linked List Cycle II
Medium

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.

https://leetcode.com/problems/linked-list-cycle-ii/
 */

    ListNode head;
    ListNode tail;


    public static void main(String[] args) {
        LinkedListCycle_II list = new LinkedListCycle_II();
        list.add(3);
        list.add(2);
        list.add(0);
        list.add(-4);
        list.tail.next = list.head.next;
        System.out.println("twoPointer(list.head) = " + twoPointer(list.head).val);
        System.out.println("withHashSet(list.head) = " + withHashSet(list.head).val);

    }

    static ListNode twoPointer(ListNode head){
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                ListNode firstNode = head;
                ListNode intersection = fast;

                while (firstNode != intersection) {
                    intersection = intersection.next;
                    firstNode = firstNode.next;
                }

                return firstNode;
            }
        }

        return null;
    }


    static ListNode withHashSet(ListNode head) {
        if (head == null) return null;
        ListNode current = head;
        HashSet<ListNode> set = new HashSet<>();
        while (current != null) {
//            if (!set.add(current)) {
//                return current;
//            }
            if (set.contains(current))
                return current;
            else
                set.add(current);
            current = current.next;
        }
        return null;
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
