public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 10, 13, 18, 20, 21};
        var search = new Search();
        // Linear Search
        // System.out.println(search.linearSearch(numbers, 18));

        // Binary search using Recurssion
        // System.out.println(search.binarySearchRec(numbers, 3));
        // System.out.println(search.binarySearchItr(numbers, 13));
        System.out.println(search.jumpSearch(numbers, 21));
    }
}
