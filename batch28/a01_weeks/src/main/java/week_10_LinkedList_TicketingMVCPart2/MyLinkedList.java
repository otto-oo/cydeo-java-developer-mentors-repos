package week_10_LinkedList_TicketingMVCPart2;

public class MyLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    ListNode head;
    ListNode tail;

    public ListNode add(int value){
        ListNode node = new ListNode(value);
        if (head == null) {
            head = node;
            return head;
        }
        ListNode current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = node;
        return head;
    }

    // O (n)
    public ListNode deleteDuplicates() {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val == fast.val) {
                fast = fast.next;
                slow.next = fast;
            } else {
                slow = fast;
                fast = fast.next;
            }
        }
        return head;
    }

    public void printList() {
        ListNode current = head;
        while (current != null) {
            if (current.next != null){
                System.out.print(current.val + " => ");
            } else
                System.out.print(current.val);
            current = current.next;
        }
        System.out.println();
    }
}
