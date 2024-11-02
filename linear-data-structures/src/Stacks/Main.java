public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.toString());
        var top  = stack.pop();
        stack.pop();
        stack.pop();
        // var top  = stack.peek();
        System.out.println(top);
        System.out.println(stack.isEmpty());
    }
}