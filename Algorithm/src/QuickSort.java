import java.util.Arrays;
import java.util.Optional;

public class QuickSort {
    public void sort(int[] array, int b) {
        int length = array.length;
        if (length < 2)  return;
        System.out.println("Before Array: " + Arrays.toString(array));

        int pivot = array[length - 1];
        // int b = -1; // boundary increase to make place for swap
        // [6, 3, 1]
        for(var i = 0; i < length; i++) {
            // System.out.println("i: " + i + ", array[i]: " + array[i] + " b: " + b + ", pivot: " + pivot + ", pivot >= array[i]" );
            if (pivot >= array[i]) {
                b++;
                if (pivot == 6) {
                    System.out.println(i + " i, b :" +b);
                }
                var temp = array[i];
                array[i] = array[b];
                array[b] = temp;
            }

        }

        int[] left = new int[b];
        for(int i = 0; i < left.length; i++){
            left[i] = array[i];
        }

        int[] right = new int[length - b - 1];
        for(int i = 0; i < right.length; i++) 
            right[i] = array[b + i + 1];
        

        // System.out.println("Length " + length + ", b: " + b);
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Left: " + Arrays.toString(left) + " Pivot: " + pivot + " Right: " + Arrays.toString(right));
        
        sort(array);
        sort(array, b-1);
        System.out.println("---Second Inn---");
        System.out.println("After: Array: " + Arrays.toString(array));
        System.out.println("After: Left: " + Arrays.toString(left) + " Pivot: " + pivot + " Right: " + Arrays.toString(right) + " End---");
        
        // System.out.println(Arrays.toString(left));
        
    }

    public void sort(int[] array) {
        int b = -1;
        sort(array, b);
        return;
    }

}
