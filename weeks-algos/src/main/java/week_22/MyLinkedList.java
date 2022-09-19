package week_22;

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

    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " => ");
            current = current.next;
        }
        System.out.println();
    }
}
