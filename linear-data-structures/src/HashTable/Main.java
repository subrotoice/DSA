import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // HashTable
        // put(k, v)
        // get(k): v
        // remove(k)
        // k: int
        // v: string
        // Collisions: chaining
        // LinkedList[]
        // [LL, LL, LL, LL]

        // HashTable hashTable = new HashTable();
        // hashTable.put("Goutom");
        HashTable table = new HashTable();
        table.put(1, "Goutom");
        table.put(2, "Subroto 22");
        table.put(3, "Monozit");
        table.put(4, "Sujit");
        table.put(5, "Sonjoy");
        table.put(6, "Kanon");


        // System.out.println(table.get(11));
        // table.remove(6);
        System.out.println(table.get(5));
        // System.out.println(table.get(8));
    }
}
