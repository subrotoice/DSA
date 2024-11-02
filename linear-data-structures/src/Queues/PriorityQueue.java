import java.nio.channels.IllegalSelectorException;
import java.util.Arrays;

public class PriorityQueue {
    private int[] queue;
    private int count = 0;

    public PriorityQueue(int capacity) {
        queue = new int[capacity];
    }

    public void add(int item) {
        if (isFull()) 
            throw new IllegalStateException();

        int i = shiftItemsToInsert(item);

        queue[i] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        // [1, 3, 5, 7] insert(2) 
        // [1, 3, 3, 5, 7] insert(2) 
        // [0, 1, 2, 3, 4] insert(2) 
        int i;
        // Shifting Items
        for(i = count - 1; i >= 0; i--) {
            if(queue[i] < item) // 1 < 2
                break;

            queue[i + 1] = queue[i];
        }

        return i + 1;
    }

    public int remove() {
        if(isEmpty()) 
            throw new IllegalSelectorException();

        int temp = queue[0];
        for(int i = 0; i <= count - 2; i++)
            queue[i] = queue[i + 1];

        queue[count - 1] = 0;
        count --;
        return temp;
    }

    public boolean isFull() {
        return count == queue.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        System.out.println("Count: " + count);
        return Arrays.toString(queue);
    }

}
