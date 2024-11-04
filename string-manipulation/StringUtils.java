import java.util.Arrays;

public class StringUtils {
    // Count Vowles
    public static int countVowels(String str) {
        if(str == null) return 0;
        
        int count = 0;
        String vowels = "aeiou";
        for(var ch:str.toLowerCase().toCharArray())
            if(vowels.indexOf(ch) != -1)
                count++;

        return count;
    }

    // Reverse String
    public static String reverseString(String str) {
        var length = str.length();
        if(length < 2) return str;
        int count = 0;

        StringBuilder reversed = new StringBuilder();
        for(var i = length - 1; i >= 0; i--)
            reversed.append(str.charAt(i)); // O(1) operation

        return reversed.toString();
    }
    
    // Reverse Words in a sentesce | Trees are beautiful -> beautiful are Trees
    public static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversed = new StringBuilder();
        for(var i=words.length - 1; i >= 0; i--) {
            reversed.append(words[i] + " ");
        }

        return reversed.toString().trim();
    }
    
    // Capitalized Sentence | Trees are beautiful -> Trees Are Beautiful
    public static String capitalize(String sentence) {
        if(sentence == null || sentence.trim().isEmpty()) return "";

        String[] words = sentence.trim().replaceAll(" +", " ").split(" ");

        for(var i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    // Ana Grams | ABCD -> BACD
    public static boolean areAnagrams(String first, String second) {
        if(first == null || second == null) return false;

        var array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    // Palandrom | ABBA, MADAM | It involves a lot of operation
    public static boolean isPalindromeWithLibrary(String word) {
        if(word == null) return true;

        var input = new StringBuilder(word);
        input.reverse();
        return input.toString().equals(word);
    }

    // Palandrom | ABBA, MADAM | It O(n/2)
    public static boolean isPalindromeWithCharArray(String word) {
        if(word == null) return true;

        char[] wordArray = word.toCharArray();
        var left = 0;
        var right = word.length() - 1;

        while (left < right) {
            if (wordArray[left] != wordArray[right] )
                return false;
            
            left++; 
            right--; 
        }

        return true;
    }

    // Palandrom | ABBA, MADAM | It O(n/2) | charAt
    public static boolean isPalindrome(String word) {
        if(word == null) return false;

        var lowerCaseWord = word.toLowerCase();
        var left = 0;
        var right = lowerCaseWord.length() - 1;

        while (left < right) 
            if (lowerCaseWord.charAt(left++) != lowerCaseWord.charAt(right--))
                return false;
    
        return true;
    }
}
