import java.util.NoSuchElementException;

public class SinglyLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public int removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        int value = head.data;
        head = head.next;
        return value;
    }

    // Positions start at 1 
    public void insertAtPosition(int position, int value) {
        if (position < 1) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        if (position == 1) {
            addFirst(value);
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Invalid position: " + position);
            }
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
    }

    // Inserts immediately after the first node containing key
    public void insertAfter(int key, int value) {
        Node current = head;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            throw new NoSuchElementException("Key not found: " + key);
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
    }

    // Inserts immediately before the first node containing key
    public void insertBefore(int key, int value) {
        if (head == null) {
            throw new NoSuchElementException("Key not found: " + key);
        }
        if (head.data == key) {
            addFirst(value);
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != key) {
            current = current.next;
        }
        if (current.next == null) {
            throw new NoSuchElementException("Key not found: " + key);
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
    }

    public int deleteAtPosition(int position) {
        if (position < 1 || head == null) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        if (position == 1) {
            return removeFirst();
        }

        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Invalid position: " + position);
            }
            current = current.next;
        }
        if (current == null || current.next == null) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        int value = current.next.data;
        current.next = current.next.next;
        return value;
    }

    // Deletes the first node containing key
    public int deleteWithKey(int key) {
        if (head == null) {
            throw new NoSuchElementException("Key not found: " + key);
        }
        if (head.data == key) {
            return removeFirst();
        }

        Node current = head;
        while (current.next != null && current.next.data != key) {
            current = current.next;
        }
        if (current.next == null) {
            throw new NoSuchElementException("Key not found: " + key);
        }

        int value = current.next.data;
        current.next = current.next.next;
        return value;
    }
}
