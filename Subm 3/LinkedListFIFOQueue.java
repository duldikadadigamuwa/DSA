
public class LinkedListFIFOQueue {

    // Node structure
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node front;
    Node rear;

    // Enqueue
    public void enqueue(int value) {

        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue
    public int dequeue() {

        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }

        int value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    // Peek
    public int peek() {

        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }

        return front.data;
    }

    // Check if empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display
    public void display() {

        Node current = front;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        LinkedListFIFOQueue queue = new LinkedListFIFOQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Front: " + queue.peek());
        System.out.println("Removed: " + queue.dequeue());

        queue.display();
    }
}
