import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myArray = {6, 3, 1, 10};
        var sorter = new QuickSort();
        System.out.println(Arrays.toString(myArray));
        sorter.sort(myArray);
        System.out.println(Arrays.toString(myArray));
        // test1(2, 4);
    }

    public static void test1(int a, int b ) {
        System.out.println("a: " + a + " b: " + b);
    }

}
