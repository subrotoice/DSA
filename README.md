A linear data structure is a type of data structure where elements are arranged in a sequential manner, and each element is connected to its previous and next element. This organization allows for easy traversal and manipulation of the data, as elements are accessed one after another. Linear data structures can be static (fixed size) or dynamic (size can change during runtime).

Here are some common types of linear data structures:

### 1. Arrays
- **Description**: An array is a collection of elements identified by index or key, where all elements are of the same type.
- **Characteristics**: Fixed size, random access.
- **Operations**: Access (O(1)), insertion (O(n)), deletion (O(n)).

### 2. Linked Lists
- **Description**: A linked list is a sequence of nodes where each node contains data and a reference (or link) to the next node in the sequence.
- **Types**: Singly linked list, doubly linked list, circular linked list.
- **Characteristics**: Dynamic size, sequential access.
- **Operations**: Access (O(n)), insertion (O(1) if at the beginning), deletion (O(1) if at the beginning).

### 3. Stacks
- **Description**: A stack is a collection of elements that follows the Last In, First Out (LIFO) principle.
- **Characteristics**: Dynamic size, elements are added and removed from the same end (top).
- **Operations**: Push (O(1)), pop (O(1)), peek (O(1)).

### 4. Queues
- **Description**: A queue is a collection of elements that follows the First In, First Out (FIFO) principle.
- **Types**: Simple queue, circular queue, priority queue, double-ended queue (deque).
- **Characteristics**: Dynamic size, elements are added at the rear and removed from the front.
- **Operations**: Enqueue (O(1)), dequeue (O(1)), peek (O(1)).

### 5. Strings
- **Description**: A string is a sequence of characters and is often treated as a linear data structure because of its sequential nature.
- **Characteristics**: Can be fixed or dynamic size depending on the programming language.
- **Operations**: Access (O(1)), concatenation (O(n)), substring (O(n)).

### Advantages of Linear Data Structures
- **Simplicity**: Easy to implement and understand.
- **Efficiency**: Good performance for simple operations and sequential access.

### Disadvantages of Linear Data Structures
- **Fixed Size**: Arrays have a fixed size which can be limiting.
- **Sequential Access**: Linked lists require sequential access, which can be slower for large datasets compared to random access structures.
- **Memory Usage**: Linked lists require additional memory for pointers.

### Use Cases
- **Arrays**: Used for storing and accessing data with an index, such as lists of items.
- **Linked Lists**: Used in scenarios where frequent insertion and deletion operations are required.
- **Stacks**: Used in function call management, undo mechanisms in software, and syntax parsing.
- **Queues**: Used in scheduling algorithms, order processing systems, and breadth-first search algorithms.

Understanding these basic linear data structures is crucial for solving many computational problems and forms the foundation for more complex data structures and algorithms.


# Ch-1: Array

```java
// Declaration
type[] arrayName;
int[] myArray;
String[] myStringArray;

// Instantiation
myArray = new int[10]; // array of 10 integers
myStringArray = new String[5]; // array of 5 strings

int[] myArray = new int[10];
String[] myStringArray = new String[5];

// Initialization
int[] myArray = {1, 2, 3, 4, 5};
String[] myStringArray = {"Hello", "World", "Java"};

```

In Java, if you assign one array to another, such as arrayOne = arrayTwo, you are not copying the contents of the array. Instead, you are copying the reference, which means both arrayOne and arrayTwo will refer to the same array in memory.

```java
int[] arrayOne = {1, 2, 3};
int[] arrayTwo = {4, 5, 6};

// Assign arrayTwo to arrayOne
arrayOne = arrayTwo;

// Now both arrayOne and arrayTwo point to the same array {4, 5, 6}
System.out.println("arrayOne: " + Arrays.toString(arrayOne)); // Output: [4, 5, 6]
System.out.println("arrayTwo: " + Arrays.toString(arrayTwo)); // Output: [4, 5, 6]
```

## Creating Array, Insert, Remove, Print

```java
// Main.java
package com.subroto;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(3);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insert(50);
        numbers.print();
    }
}

// Array.java (Array Class)
package com.subroto;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i =0; i<count;i++) {
            System.out.println(items[i]);
        }
    }

    public void insert(int item){
        // If the array is full, resize it
        if (items.length == count) {
            // Create a new array (twice the size)
            int[] newItems = new int[count*2];

            // Copy all the existing items
            for (int i=0; i<count; i++)
                newItems[i]=items[i];

            // Set "items" to this new array
            items=newItems;
        }
        // copy all existing items
        items[count++]=item;
    }
}

```