
public class CircularDoublyLinkedList {

    // Node structure
    class Node {
        int data;
        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    // nsert First
    public void insertFirst(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
            newNode.previous = newNode;
            return;
        }

        newNode.next = head;
        newNode.previous = tail;

        tail.next = newNode;
        head.previous = newNode;

        head = newNode;
    }

    // Insert Last
    public void insertLast(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
            newNode.previous = newNode;
            return;
        }

        newNode.next = head;
        newNode.previous = tail;

        tail.next = newNode;
        head.previous = newNode;

        tail = newNode;
    }

    // Insert at Position
    public void insertAtPosition(int data, int pos) {

        if (pos < 1) {
            return;
        }

        if (pos == 1) {
            insertFirst(data);
            return;
        }

        if (head == null) {
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos - 1; i++) {

            if (temp == tail) {
                return;
            }

            temp = temp.next;
        }

        if (temp == tail) {
            insertLast(data);
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.previous = temp;

        temp.next.previous = newNode;
        temp.next = newNode;
    }

    // Insert After
    public void insertAfter(int data, int key) {

        if (head == null) {
            return;
        }

        Node temp = head;

        while (temp.data != key) {

            temp = temp.next;

            if (temp == head) {
                return;
            }
        }

        if (temp == tail) {
            insertLast(data);
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.previous = temp;

        temp.next.previous = newNode;
        temp.next = newNode;
    }

    // Insert Before
    public void insertBefore(int data, int key) {

        if (head == null) {
            return;
        }

        Node temp = head;

        while (temp.data != key) {

            temp = temp.next;

            if (temp == head) {
                return;
            }
        }

        if (temp == head) {
            insertFirst(data);
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp;
        newNode.previous = temp.previous;

        temp.previous.next = newNode;
        temp.previous = newNode;
    }

    // Delete Last
    public void deleteLast() {

        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.previous;

        tail.next = head;
        head.previous = tail;
    }

    //  Delete at Position
    public void deleteAtPosition(int pos) {

        if (head == null || pos < 1) {
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos; i++) {

            if (temp == tail) {
                return;
            }

            temp = temp.next;
        }

        if (temp == tail) {
            deleteLast();
            return;
        }

        if (temp == head) {
            head = head.next;

            head.previous = tail;
            tail.next = head;

            return;
        }

        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;
    }

    // Main method
    public static void main(String[] args) {

        CircularDoublyLinkedList list =
                new CircularDoublyLinkedList();

        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(40);

        list.insertAtPosition(30, 3);

        list.insertAfter(35, 30);
        list.insertBefore(15, 20);

        list.deleteLast();
        list.deleteAtPosition(2);

    }
}
