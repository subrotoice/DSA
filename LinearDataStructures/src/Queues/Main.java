
public class Main {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);

        priorityQueue.add(6);
        priorityQueue.add(3);
        priorityQueue.add(5);
        priorityQueue.add(7);
        priorityQueue.add(2);
        System.out.println(priorityQueue.toString());
        
        while (!priorityQueue.isEmpty()) 
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.toString());
        
    }

}