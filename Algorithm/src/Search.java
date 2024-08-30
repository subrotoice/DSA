public class Search {
    public int linearSearch(int[] array, int item) {
        for(var i = 0; i < array.length; i++)
            if (array[i] == item) 
                return i;

        return -1;
    }

    // Binary Search (Recursive)
    // [1, 3, 5, 7, 9]
    public int binarySearchRec(int[] array, int item) {
        return binarySearchRec(array, item, 0, (array.length - 1));
    }
    
    public int binarySearchRec(int[] array, int item, int left, int right) {
        if (right < left) return -1;

        int middle = (left + right) / 2;
        if (array[middle] == item) return middle;

        if(array[middle] > item)
            return binarySearchRec(array, item, left, middle - 1);

        return binarySearchRec(array, item, middle + 1, right);
    }

    // [1, 3, 5, 7, 10, 13, 18] (Iterative)
    public int binarySearchItr(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2;

        while (left <= right ) {
            middle = (left + right) / 2;

            if (array[middle] == target) 
                return middle;
            
            if (array[middle] > target) 
                right = middle - 1;
            else
                left = middle + 1;
        }

        return -1;
    }
}
