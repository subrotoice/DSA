import java.util.Arrays;

public class ArrayQueue {
    private int[] queue;
    private int front = 0;
    private int rear = 0;
    private int count = 0;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
    }
    

    public void enqueue(int item) {

        if (queue.length <= count) 
            throw new IllegalStateException();

        queue[rear] = item;
        rear = (rear+1) % queue.length;
        count++;
        System.out.println(count);
    }

    public int dequeue() {
        if (isEmpty()) 
            throw new IllegalStateException();

        var item = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        count--;
        System.out.println(count);
        return item;
    }

    public int peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        return count == 0;
        // return front >= rear;
    }

    public boolean isFull() {
        return queue.length <= rear;
    }

    public int count() {
        return count;
    }

    @Override
    public String toString() {
        // var content = Arrays.copyOfRange(queue, front, rear);
        return Arrays.toString(queue);
    }

}
