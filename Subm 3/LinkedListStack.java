
public class LinkedListStack {

    // Node structure
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node top;

    // Push
    public void push(int value) {

        Node newNode = new Node(value);

        newNode.next = top;
        top = newNode;
    }

    // Pop
    public int pop() {

        if (top == null) {
            throw new RuntimeException("Stack is empty");
        }

        int value = top.data;
        top = top.next;

        return value;
    }

    // Peek
    public int peek() {

        if (top == null) {
            throw new RuntimeException("Stack is empty");
        }

        return top.data;
    }

    // Check if empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display
    public void display() {

        Node current = top;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Top: " + stack.peek());
        System.out.println("Removed: " + stack.pop());

        stack.display();
    }
}
