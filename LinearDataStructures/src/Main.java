import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        // System.out.println(list.indexOf(30));
        // System.out.println(list.contains(40));
        // list.removeFirst();
        // list.removeLast();
        System.out.println(list.size());

        System.out.println(Arrays.toString(list.toArray()));

    }
}