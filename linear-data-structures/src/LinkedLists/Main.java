import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // LinkedList list = new LinkedList();

        // list.addLast(10);
        // list.addLast(20);
        // list.addLast(30);
        // list.addLast(40);
        // // System.out.println(list.indexOf(30));
        // // System.out.println(list.contains(40));
        // // list.removeFirst();
        // // list.removeLast();
        // System.out.println(list.size());

        // System.out.println(Arrays.toString(list.toArray()));

        // var list = new LinkedList<Integer>();
        // list.add(10);
        // list.add(20);
        // list.add(30);
        // list.addFirst(5);

        // System.out.println(list);

        MyLinkedList list = new MyLinkedList();
        list.addFirst(5);
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(50);
        // list.removeLast();
        // list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
    }
}