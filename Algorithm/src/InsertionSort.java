public class InsertionSort {
    /*  [0, 1, 2, 3, 4]
        [8, 2, 4, 1, 3] */
    public void sort(int[] input) {
        var length = input.length;
        for(var i = 1; i < length; i++) {
            var current = input[i];
            int j = i;
            while (j > 0 && input[j - 1] > current) {
                input[j] = input[j - 1];
                j--;
            }
            input[j] = current;
        }
    }
}
