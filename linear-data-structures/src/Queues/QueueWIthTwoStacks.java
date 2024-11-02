import java.util.Stack;

public class QueueWIthTwoStacks {
    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> stack2 = new Stack();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        moveStack1ToStack2();

        return stack2.pop();
            
    }

    public int peek() {
        moveStack1ToStack2();
                
        return stack2.peek();
    }

    private void moveStack1ToStack2() {
        if (isEmpty()) 
        throw new IllegalArgumentException();

        if(stack2.empty())
            while (!stack1.empty()) 
                stack2.push(stack1.pop());
    }

    public boolean isEmpty() {
            return stack1.empty() && stack2.empty();
    }
}
