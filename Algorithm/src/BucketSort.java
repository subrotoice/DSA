import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public void sort(int[] array, int numberOfBucket) {
        List<List<Integer>> buckets = createBuckets(array, numberOfBucket);

        var i = 0;
        for(var bucket : buckets) {
            Collections.sort(bucket);
            for(var item : bucket) 
                array[i++] = item;
        }
    }

    private List<List<Integer>> createBuckets(int[] array, int numberOfBucket) {
        List<List<Integer>> buckets = new ArrayList<>();

        // List contains another List so it make instance of each inner List
        for(var i = 0; i < numberOfBucket; i++)
            buckets.add(new ArrayList<>());

        for(int item : array){
            // Here get return the index of a bucket. Here each bucket is a linked list of integer
            buckets.get(item / numberOfBucket).add(item);
        }
        return buckets;
    }
}
