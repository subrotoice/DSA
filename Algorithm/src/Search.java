public class Search {
    public int linearSearch(int[] array, int item) {
        for (var i = 0; i < array.length; i++)
            if (array[i] == item)
                return i;

        return -1;
    }

    // Binary Search (Recursive)
    // [1, 3, 5, 7, 9]
    public int binarySearchRec(int[] array, int item) {
        return binarySearchRec(array, item, 0, (array.length - 1));
    }

    private int binarySearchRec(int[] array, int item, int left, int right) {
        if (right < left)
            return -1;

        int middle = (left + right) / 2;
        if (array[middle] == item)
            return middle;

        if (array[middle] > item)
            return binarySearchRec(array, item, left, middle - 1);

        return binarySearchRec(array, item, middle + 1, right);
    }

    // [1, 3, 5, 7, 10, 13, 18] 3 (Iterative)
    public int binarySearchItr(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2;
        // System.out.println(middle);
        while (left < right) {
            middle = (left + right) / 2;

            if (array[middle] == target)
                return middle;

            if (target < array[middle])
                right = middle - 1;
            else
                left = middle + 1;
            
        }
        return -1;
    }

    public int ternarySearchRec(int[] array, int target) {
       return ternarySearchRec(array, target, 0, array.length-1);
    }

    private int ternarySearchRec(int[] array, int target, int left, int right) {
        if(left > right) return -1;
        
        int partitionSize = (right-left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (array[mid1] == target) return mid1;
        if (array[mid2] == target) return mid2;

        // Left Partition
        if(array[mid1] > target) return ternarySearchRec(array, target, left, mid1-1);
        // Middle Partition
        if(array[mid1] < target) return ternarySearchRec(array, target, mid1+1, mid2-1);
        // Right Partition
        return ternarySearchRec(array, target, mid2+1, right);
    }

    // jump search
    // [1, 3, 5, 7, 10, 13, 18, 20, 21]
    public int jumpSearch(int[] array, int target) {
        int length = array.length;
        int blockSize =  (int)Math.sqrt(length);
        int start = 0;
        int next = blockSize;

        while (start < length && array[next - 1] < target ) {
            start = next;
            next += blockSize; 

            if (next > array.length)
                next = array.length;
        }

        for(int i = start; i < next; i++) 
            if (array[i] == target) return i;

        return -1;
    }
}
