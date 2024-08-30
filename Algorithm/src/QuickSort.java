import java.util.Arrays;

public class QuickSort {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }
    public void sort(int[] array, int start, int end) {
        if(start >= end) return;

        var boundary = partition(array, start, end);
        sort(array, start, boundary - 1); // Left part
        sort(array, boundary + 1, end); // right part

    }

    private int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1;

        for(var i = start; i <= end; i++) {
            if (array[i] <= pivot)
                swap(array, ++boundary, i);
        }

        return boundary;
    }

    private void swap(int[] array, int boundary, int i) {
        var temp = array[i];
        array[i] = array[boundary];
        array[boundary] = temp;
    }

}
