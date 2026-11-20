import java.util.Stack;
import java.util.NoSuchElementException;

public class StackQueue {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> auxStack = new Stack<>();

    public void enqueue(int value) {
        while (!mainStack.isEmpty()) {
            auxStack.push(mainStack.pop());
        }

        mainStack.push(value);

        while (!auxStack.isEmpty()) {
            mainStack.push(auxStack.pop());
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return mainStack.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return mainStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }
}
