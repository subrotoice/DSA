import java.util.NoSuchElementException;

public class MyLinkedList {
    private class Node {
        private int value;
        private Node next;
        
        public Node(int item) {
            this.value = item;
        }
    }

    private Node first;
    private Node last;
    private int count = 0;

    public void addLast(int item) { // 5, 10, 20
        var newNode = new Node(item);
        if(first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
        }
        count++;
    }

    public void addFirst(int item) { // 5, 10, 20
        var newNode = new Node(item);

        if(first == null) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        count++;
    }

    public void removeLast() { // 5, 10, 20
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            return;
        }

        var previous = findPrevious(last);
        last = previous;
        last.next = null;

        count--;
    }

    public void reverse() { // 10, 20, 30, 40
        if (isEmpty()) return;

        var p = first;
        var c = p.next;

        while (c != null) {
            var next = c.next;
            c.next = p;
            p = c;
            c = next;
        }
    }

    public Node findPrevious(Node node) { // 5, 10, 20
        var current = first;

        while (current != null) {
            if (current.next == node) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    public int[] toArray() { // 5, 10, 20
        int[] result = new int [100 ];
        var node = first;
        int index = 0;

        while (node != null) {
            result[index++] = node.value;
            node = node.next;
        }

        return result;
    }

    public boolean isEmpty() { // 5, 10, 20
        return first == null;
    }



}
