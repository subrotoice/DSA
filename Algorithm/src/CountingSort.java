import java.util.Arrays;

public class CountingSort {
    public void sort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int[] count = new int[max + 1];

        for(int item: array) 
            count[item]++;
        
        var counter = 0;
        for(int i = 0; i < count.length; i++) {
            for(int j = 0; j < count[i]; j++)
                array[counter++] = i;
        }
    }
}
