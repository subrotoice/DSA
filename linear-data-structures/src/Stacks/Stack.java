import java.util.Arrays;

public class Stack {
    private int[] stack = new int[5];
    private int count = 0;

    public void push(int input) {
        if (count == stack.length) 
            throw new StackOverflowError();

        stack[count++] = input;
    }

    public int pop() {
        if (count <= 0) 
            throw new IllegalStateException();

        return stack[--count];
    }

    public int peek() {
        return stack[count - 1];
    }

    public boolean isEmpty() {
        return count <= 0;
    }

    @Override
    public String toString(){
        var content = Arrays.copyOfRange(stack, 0, count);
        return Arrays.toString(content);
    }
}
