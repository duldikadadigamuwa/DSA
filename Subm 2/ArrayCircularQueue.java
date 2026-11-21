import java.util.NoSuchElementException;

public class ArrayCircularQueue {
    private int[] queue;
    private int front = -1;
    private int rear = -1;

    public ArrayCircularQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        queue = new int[capacity];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % queue.length == front;
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int value = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % queue.length;
        }
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue[front];
    }
}
