package week_10_LinkedList_TicketingMVCPart2;

public class MySinglyLinkedListApp {
    public static void main(String[] args) {

        MySinglyLinkedList linkedList = new MySinglyLinkedList();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.printNodes();

        System.out.println("indexOf(3): " + linkedList.indexOf(3));
        System.out.println("size: "+ linkedList.size);
        linkedList.addFirst(0);

        linkedList.deleteById(5);
        linkedList.printNodes();

    }
}
