import java.util.Stack;

public class StringRev {
    public String reverse(String input) {
        if (input == null) 
            throw new IllegalArgumentException();
            
        Stack<Character> stack =  new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reversed = "";

        while (!stack.empty()) {
            reversed += stack.pop();
        }

        return reversed;
    }

}
