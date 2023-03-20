package week_10_LinkedList_TicketingMVCPart2;

class MySinglyLinkedList {
    Node<Integer> head;
    Node<Integer> tail;
    int size;

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(int data) {
        // create a new node object from data
        Node<Integer> node = new Node<>(data);
        // case 1: list empty
        if (isEmpty()) {
            head = tail = node;
        } else {// case 2 : list is not empty
            node.next = head;
            head = node;
        }
        //increase size
        size++;
    }

    void add(int data) {
        // create a new node object from data
        Node<Integer> node = new Node<>(data);

        if (isEmpty()) { // if the list is empty
            head = tail = node;
        } else { // if there are elements in list
            tail.next = node;
            tail = node;
        }
        size++;
    }

    void add(int index, int data) {
        // insert
    }

    void deleteById(int id) {
        // check if empty
        if (isEmpty()) System.out.println("List is empty!!!");
        // assign prev and current with the head

        Node<Integer> prev = head;
        Node<Integer> current = head;
        while (current != null) {
            if (current.value == id) {// there is a match
                //case 1: head
                if (current == head) {
                    head = current.next;
                    current.next = null;
                }
                // case 2 : tail
                else if (current == tail) {
                    tail = prev;
                    prev.next = null;//Ex -Tail will be eligible for Garbage Collection
                }
                // case 3 : middle
                else {
                    prev.next = current.next;
                    current.next = null;// Current will be eligible for Garbage Collection
                }
                // after deletion
                size--;
            }
            // move forward on the elements of the list
            prev = current;
            current = current.next;

        }

    }

    int indexOf(int id) {
        if (isEmpty()) return -1;
        int pos = 0;
        // iterate through the list
        Node<Integer> current = head;// set my current with the starting element;
        while (current != null) {
            if (current.value == id) return pos;
            pos++;
            current = current.next;
        }
        return -1;
    }

    void printNodes() {
        Node<Integer> current = head;
        while (current != null) {
            if (current.next == null)
                System.out.println(current.value + "=> null");
            else {
                System.out.print(current.value + "=> ");
            }
            current = current.next;
        }
    }


    public void removeKthFromLast2(int k) {
        Node<Integer> ptr1 = head;
        Node<Integer> ptr2 = head;
        for (int i = 0; i < k - 1; i++) {

            ptr2 = ptr2.next;

            if (ptr2 == null) System.out.println("Less than k elements");

            else if (ptr2.next == null) {
                head = ptr1.next;
                ptr1.next = null;
                return;
            }
        }
        while (ptr2.next.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr1.next = ptr1.next.next;
        ptr1 = ptr1.next;
        ptr1 = null;
    }


}