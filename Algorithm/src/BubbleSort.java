public class BubbleSort {
    // [0, 1, 2, 3, 4]
    // [8, 4, 5, 9, 2]
    public void sort(int[] input) {
        int length = input.length;
        boolean isShorted;

        for(var i = 0; i < length; i++) {
            isShorted = true;
            for(var j = 0; j < length - i - 1; j++) 
                if (input[j] > input[j + 1]) {
                    isShorted = false;
                    swap(input, j);
                }
                if (isShorted) 
                    return;

        }
                
    }

    private void swap(int[] input, int j) {
        var temp = input[j];
        input[j] = input[j + 1];
        input[j + 1] = temp;
    }
}