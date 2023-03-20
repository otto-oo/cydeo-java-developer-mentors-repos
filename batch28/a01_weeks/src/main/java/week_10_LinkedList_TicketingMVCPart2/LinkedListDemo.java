package week_10_LinkedList_TicketingMVCPart2;

class LinkedListDemo {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("Node1's address is: " + node1 + "  Node1' next address is " + node1.next);
        System.out.println("Node2's address is: " + node2 + "  Node2' next address is " + node2.next);
        System.out.println("Node3's address is: " + node3 + "  Node3' next address is " + node3.next);
        System.out.println("Node4's address is: " + node4 + "  Node4' next address is " + node4.next);

        Node<Integer> current;
        current = node1;
        while (current != null) {
            System.out.println("Value of node is: " + current.value);
            current=current.next;
        }
    }



}
