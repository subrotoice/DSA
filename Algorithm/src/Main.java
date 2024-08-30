import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 10, 13, 18};
        var search = new Search();
        System.out.println(search.binarySearchItr(numbers, 7));
    }
}
