
public class UnboundedArrayStack {

    private int[] array;
    private int top;
    private static final int INITIAL_CAPACITY = 2;

    // Constructor
    public UnboundedArrayStack() {
        array = new int[INITIAL_CAPACITY];
        top = -1;
    }

    // Push operation
    public void push(int value) {

        // Increase capacity if array is full
        if (top == array.length - 1) {
            resize(array.length * 2);
        }

        array[++top] = value;
    }

    // Pop operation
    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        int value = array[top--];

        // Decrease capacity when usage reaches 25%
        if (top + 1 > 0 &&
            top + 1 == array.length / 4 &&
            array.length > INITIAL_CAPACITY) {

            resize(array.length / 2);
        }

        return value;
    }

    // Peek operation
    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return array[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Get stack size
    public int size() {
        return top + 1;
    }

    // Resize the array
    private void resize(int newCapacity) {

        int[] newArray = new int[newCapacity];

        for (int i = 0; i <= top; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    // Display stack elements
    public void display() {

        for (int i = top; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }

    // Main method
    public static void main(String[] args) {

        UnboundedArrayStack stack = new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Stack elements:");
        stack.display();

        System.out.println("Top element: " + stack.peek());

        System.out.println("Removed: " + stack.pop());
        System.out.println("Removed: " + stack.pop());

        System.out.println("Current size: " + stack.size());
    }
}
