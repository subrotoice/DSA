import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;
        
        public Node(int value) {
            this.value=value;
        }
    }
    
    private Node first;
    private Node last;
    private int size = 0;

    // addLast
    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty()) 
            first = last = node;
        
        else {
            last.next = node; // Call stack er next
            last = node; // last property of this object
        }
        size++;
    }

    // addFirst
    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty())
            first=last=node;

        else {
            node.next=first;
            first=node;
        }

        size++;
    }

    // removeFirst
    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) 
            first = last = null;
        else {
            var second = first.next;
            first.next=null;
            first=second;
        }

        size--;
    }

    // removeLast
    public void removeLast() {
        // Validation
        if (isEmpty()) 
            throw new NoSuchElementException();

        if (first == last)
            first = last; 
        else {
            // Find second last node. you can make getPrevious(last) function
            var current = first;
            var previous = current;
    
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
    
            last = previous;
            last.next = null;
        }

        size--;
    }

    // contains (What a logic)
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    // indexOf
    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while(current != null) {
            if (current.value == item) 
                return index;
            
            current = current.next;
            index++;
        }

        return -1;
    }

    // Size
    public int size() {
        return size;
    }

    // Converting Linked Lists to Arrays
    public int[] toArray() {
        int[] array = new int[size];
        var current = first;

        for(int i = 0; i < size; i++) {
            array[i] = current.value;
            current=current.next;
        }

        return array;
    }


    private boolean isEmpty() {
        return first == null;
    }
}
