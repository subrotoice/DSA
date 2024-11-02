import java.util.HashSet;
import java.util.Set;

public class CharFinder {
    private String input;

    public CharFinder(String str) {
        input = str;
    }

    public char findFirstRepetedCharacter() {
        Set<Character> set = new HashSet<>();
        for(char ch : input.toCharArray()) {
            if (set.contains(ch)) 
                return ch;
        set.add(ch);
        }

        return Character.MIN_VALUE; // If nothing find

    }

}
