import java.util.LinkedList;

public class HashTable {
    private class Entry{
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    // Very tricky here: LinkedList[] it is LinkedList array linke int array: int[], char[]
    // this array contain Entry object. entities is array name and size is 5. 
    // Later on we will create instance of this class
    private LinkedList<Entry>[] entries = new LinkedList[5];
    
    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }
        
        // var bucket = getOrCreateBucket(key);
        // // Entry entry = new Entry(key, value);
        // bucket.addLast(new Entry(key, value));
        getOrCreateBucket(key).addLast(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);
        // if (entry == null)
        //     return null;

        // return entry.value;

        return (entry == null) ? null : entry.value;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null) 
            throw new IllegalStateException();

        // var bucket = getBucket(key);
        // bucket.remove();
        getBucket(key).remove();
    }

    private LinkedList<Entry> getBucket(int key) {
        // var index = hash(key);
        // return entries[index];
        return entries[hash(key)]; // More efficient
    }

    public LinkedList<Entry> getOrCreateBucket(int key) {
        var index = hash(key);
        var bucket = entries[index];
        if (bucket == null) {
            entries[index] = new LinkedList<>();
            return entries[index];
        }

        return bucket;
    }

    private Entry getEntry(int key) {
        // var index = hash(key);
        // var bucket = entries[index];
        var bucket = getBucket(key);

        if (bucket != null) {
            for(var entry: bucket)
                if (entry.key == key) 
                    return entry;
        }

        return null;
    }

    private int hash(int key) {
        return key % entries.length;
    }

}
