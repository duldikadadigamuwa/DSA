import java.util.NoSuchElementException;

public class DoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        if (head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        newNode.prev = tail;
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public int removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        int value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        return value;
    }

    public int removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        int value = tail.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
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
        newNode.prev = current;
        if (current.next == null) {
            tail = newNode;
        } else {
            current.next.prev = newNode;
        }
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
        newNode.prev = current;
        if (current.next == null) {
            tail = newNode;
        } else {
            current.next.prev = newNode;
        }
        current.next = newNode;
    }

    // Inserts immediately before the first node containing key
    public void insertBefore(int key, int value) {
        Node current = head;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            throw new NoSuchElementException("Key not found: " + key);
        }
        if (current == head) {
            addFirst(value);
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
    }

    public int deleteAtPosition(int position) {
        if (position < 1) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        Node current = head;
        for (int i = 1; i < position; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Invalid position: " + position);
            }
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        if (current == head) {
            return removeFirst();
        }
        if (current == tail) {
            return removeLast();
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        return current.data;
    }

    // Deletes the first node containing key
    public int deleteWithKey(int key) {
        Node current = head;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            throw new NoSuchElementException("Key not found: " + key);
        }
        if (current == head) {
            return removeFirst();
        }
        if (current == tail) {
            return removeLast();
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        return current.data;
    }
}
