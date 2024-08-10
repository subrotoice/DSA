public class SelectionSort {
/*  [0, 1, 2, 3, 4]
    [8, 2, 4, 1, 3] */
    public void sort (int[] input) {
        int lenght = input.length;
        for(int i = 0; i < lenght; i++) {
            var minIndex = getMinIndex(input, lenght, i);
            
            swap(input, i, minIndex);
            
        }
    }

    private int getMinIndex(int[] input, int lenght, int i) {
        var minIndex = i;
        for(int j = i; j < lenght; j++)
            if (input[minIndex] > input[j])
                minIndex = j;
        return minIndex;
    }

    private void swap(int[] input, int i, int minIndex) {
        if(i == minIndex) return;

        var temp = input[minIndex];
        input[minIndex] = input[i];
        input[i] = temp;
    }

}
