public class MargeSort {
    public void sort(int[] array) {
        int length = array.length;
        if (length < 2) return;

        int middle = length / 2;

        int[] left = new int[middle];
        for(var i = 0; i < middle; i++)
            left[i] = array[i];

        int[] right = new int[length - middle];
        for(var i = 0; i < right.length; i++ ) 
            right[i] = array[middle + i];
        
        sort(left);
        sort(right);

        marge(left, right, array); // passing "array" most tircky part
    }

    private void marge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < left.length) {
            if(left[i] < right[j])
                result[k++] = left[i++];
            else 
                result[k++] = right[j++];
        }

        while (i < left.length) 
            result[k++] = left[i++];

        while (j < left.length)
            result[k++] = left[j++];
    }
}
