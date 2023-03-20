package week_11_afterBreak;

public class DeleteNnodesAfterMnodes {

    public static void main(String[] args) {
        Node head = new Node(1);
//        Node node1 = new Node(2);
//        Node node2 = new Node(3);
//        Node node3 = new Node(4);
//        Node node4 = new Node(5);
//        Node node5 = new Node(6);
//        Node node6 = new Node(7);
//        Node node7 = new Node(8);
//        Node node8 = new Node(9);
//        Node node9 = new Node(10);
//        Node node10 = new Node(11);
//        head1.next = node1;
//        head1.next.next = node2;
//        head1.next.next.next = node3;
//        head1.next.next.next.next = node4;
//        head1.next.next.next.next.next = node5;
//        head1.next.next.next.next.next.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
//        node9.next = node10;
        Node current = head;
        for (int i = 2; i <15; i++) {
            current.next = new Node(i);
            current = current.next;
        }

        print(head);
        deleteNodes(head, 1, 2);
        print(head);
    }

    public static Node deleteNodes(Node head, int m, int n) {
        Node current = head;
        Node lastM = head;
        while (current != null) {
            // initialize mCount to m and nCount to n
            int mCount = m, nCount = n;
            // traverse m nodes
            while (current != null && mCount != 0) {
                lastM = current;
                current = current.next;
                mCount--;
            }
            // traverse n nodes
            while (current != null && nCount != 0) {
                current = current.next;
                nCount--;
            }
            // delete n nodes
            lastM.next = current;
        }
        return head;
    }
    /*  Above solution time&space complexity
    Time Complexity: O(N). Here, N is the length of the linked list pointed by head. We traverse over the linked list only once.
    Space Complexity: O(1). We use constant extra space to store pointers like lastMNode and currentNode.
     */

    public static Node deleteNodes2(Node head, int m, int n) {
        Node pointer1 = head;
        Node pointer2;
        while (pointer1 != null) {
            for (int i = 1; i < m && pointer1.next != null; i++) { //go in blue
                pointer1 = pointer1.next;
            }
            pointer2 = pointer1.next;                                  //p2 to red
            for (int i = 1; i <= n && pointer2 != null; i++) {          //go in red
                pointer2 = pointer2.next;
            }
            pointer1.next = pointer2;                                  //make connection
            pointer1 = pointer2;                                       //come together
        }
        return head;
    }
    /*  Above solution time&space complexity
    Time Complexity: O(N). Here, N is the length of the linked list pointed by head. We traverse over the linked list only once.
    Space Complexity: O(1). We use constant extra space to store pointers like lastMNode and currentNode.
     */

    public static void print(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
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
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return value + " -> ";
    }
}
