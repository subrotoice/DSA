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

[Mosh DSA](https://github.com/JuanJMendoza/DataStructures-and-Algorithms)

# Ch-1: Array

Java Array Basic

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
        numbers.insert(660);
        numbers.removeAt(4);
        System.out.println(numbers.indexOf(200));
        numbers.print();
    }
}
```

```java
// Array.java (Array Class)
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

    public int indexOf(int item) {
        // if we find it, return index
        // Otherwishe, return -1
        for(int i = 0; i < count; i++)
            if (items[i]==item)
                return i;

            return -1;
    }

    public void removeAt(int index) {
        // Validate the index
        if(index<0 || index>=count)
            throw new IllegalArgumentException();

        // Shift the intems to the left to fill the holl
        // [10, 20, 30, 40]
        // index: 1
        // 1 <- 2, 2 <- 3
        for(int i=index; i < count; i++)
            items[i] = items[i+1];

        count--;
    }
}
```

**How Code sholuld be developed**<br>
**Step1: Commenting What are you going to do?**

```java
public void removeAt(int index) {
    // Validate the index

    // Shift the intems to the left to fill the holl
    // [10, 20, 30, 40]
    // index: 1
    // 1 <- 2, 2 <- 3

    // Reduct counter to srink
}
```

**Step2: Do actual coding**

```java
public void removeAt(int index) {
    // Validate the index
    if(index<0 || index>=count)
        throw new IllegalArgumentException();

    // Shift the intems to the left to fill the holl
    // [10, 20, 30, 40]
    // index: 1
    // 1 <- 2, 2 <- 3
    for(int i=index; i < count; i++)
        items[i] = items[i+1];

    // Reduce counter to srink
    count--;
}
```

## Java Dynamic Array: Vector, ArrayList

Something that we create like Array, It's modification of array.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        // list.remove(0);

        System.out.println(list.indexOf(20));
        System.out.println(list.size());
        System.out.println(list);
    }
}
```

# Linked Lists

A linked list consists of a data element known as a node. And each node consists of two fields: one field has data, and in the second field, the node has an address that keeps a reference to the next node.

![https://prnt.sc/5WIdo_4YYyZ7](https://media.geeksforgeeks.org/wp-content/uploads/20220712172013/Singlelinkedlist.png)
![https://prnt.sc/vgpLjjyqsczk](https://www.boardinfinity.com/blog/content/images/2023/04/Linked-list-java.png)

#### Types of linked Lists

![https://prnt.sc/G4p0V0dpdWTe](https://miro.medium.com/v2/resize:fit:1400/0*0XVK02Guco9xJMJL.png)

- Advantages (Dynamic Size, Ease of Insertion/Deletion )
- Disadvantages of Linked Lists ( Memory Usage: They use more memory than arrays because of the additional storage required for pointers, Access Time: Accessing an element takes O(n) time, as it requires traversing the list from the head to the desired node)

#### Basic LinkedLists in Java

```java
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(50);
        // list.removeLast();
        System.out.println(list.contains(30));
        System.out.println(list.indexOf(30));
        System.out.println(list.size());
        System.out.println(list);

        // LinkedList to regular Array
        var array = list.toArray();

        System.out.println(Arrays.toString(array));

    }
}
```

## Exercise: Building a Linked List of own

![https://prnt.sc/PBuCRhZhFOJ9](https://i.postimg.cc/tp9tbBfc/Linked-List-transformed.png)

```java
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
```

```java
// LinkedList.java
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

    //
    private boolean isEmpty() {
        return first == null;
    }
}

```

## Singly and Doubly Linked list

![https://prnt.sc/OJT_bOEJEWlP](https://media.geeksforgeeks.org/wp-content/cdn-uploads/gq/2014/03/DLL1.png)

- Here if you want to delete second last item then need not traverse whole list. It is O(1) operation.

## Exercise: Reversiong a Linked List

```java
// Reverse Linked Lists
// 10 <- 20 -> 30 -> 40
// p    c       n
//      p       c     n
//              p     c     n
public void reverse() {
    if (isEmpty()) return;

    var previous = first;
    var current = first.next;
    var endItem= first;
    endItem.next=null;

    while (current != null) {
        var next = current.next;
        current.next = previous;
        previous=current;
        current=next;
    }

    first=previous;
    last=endItem;
    }
```

## Find k th node from the end of a linked list

```java
// 10 -> 20 -> 30 -> 40
public int getKthFromTheEnd(int k) {
    if (isEmpty())
        throw new IllegalStateException();
    var a = first;
    var b = first;
    for(int i = 0; i < k-1; i++) {
        b=b.next;
        if (b == null)
            throw new IllegalArgumentException();

    }

    while (b != last) {
        a=a.next;
        b=b.next;
    }

    return a.value;

}
```

# Stacks - Last In First Out (LIFO)

Internally we use array or linked lists to store the object in a stack. So stack is the wrapper of array or linked lists which gives us different way of storing and accessing object.

- Implement the undo feature
- Build Navigation

![https://prnt.sc/B40St89n5LaX](https://cdn.pixabay.com/photo/2016/03/31/19/16/book-1294864_1280.png)

## Stacks 4 Operations. All operation O(1)

- push(item)
- pop()
- peek() // peek from the top without deleting item.
- isEmpty()

## Java Stack

```java
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        var top = stack.pop();
        System.out.println(top);
        System.out.println(stack);
        top = stack.peek();
        System.out.println(20);
        System.out.println(stack.isEmpty()); // after two stack.pop()
    }
}
```

## Exercise: Reversing a string

```java
// Stacks/Main.jaba
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str = "abcd";
        StringReverser reverser = new StringReverser();
        var result = reverser.reverse(null);

        System.out.println(result);
    }
}
```

```java
// Simple Solution
import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if(input == null) throw new IllegalArgumentException();

        int length = input.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < length; i++)
            stack.push(input.charAt(i));

        StringBuffer reversed = new StringBuffer();

        while (!stack.empty())
            reversed.append(stack.pop());

        return reversed.toString();

    }
}

// Optimized Solution
// Stacks/StringReverser.jaba
import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if(input == null) throw new IllegalArgumentException();

        int length = input.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < length; i++)
            stack.push(input.charAt(i));

        StringBuffer reversed = new StringBuffer();

        while (!stack.empty())
            reversed.append(stack.pop());

        return reversed.toString();

    }

}
```

## Exercise: Balanced Expressions (a lot to learn)

```java
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        BalanceExpression balanceExpression = new BalanceExpression();
        var str = "(fdi(ddd))new{sdf}e{ds(sdf)f";
        System.out.println(balanceExpression.isBalanced(str));
    }
}
```

```java
// My Solution
import java.util.Stack;

public class BalanceExpression {
    public boolean isBalanced(String input) {
        if (input == "")
            return true;

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);

            if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.empty()) return false;

                var top = stack.pop();
                if (ch == ')' && top != '(')
                    return false;
                else if  (ch == '}' && top != '{')
                    return false;
                else if  (ch == ']' && top != '[')
                    return false;
            }
        }

        if (!stack.empty())
            return false;

        return true;
    }
}
```

```java
// Mosh Solution
import java.util.Stack;

public class BalanceExpression {
    public boolean isBalanced(String input) {
        if (input == "")
            return true;

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);

            if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.empty()) return false;

                var top = stack.pop();
                if (
                    (ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')
                ) return false;
            }
        }

        if (!stack.empty())
            return false;

        return true;
    }
}
```

### First layer of refactoring.

```java
import java.util.Stack;

public class BalanceExpression {
    public boolean isBalanced(String input) {
        if (input == "")
            return true;

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.empty()) return false;

                var top = stack.pop();
                if (!bracketsMatch(top, ch)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isLeftBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private boolean isRightBracket(char ch) {
        return ch == ')' || ch == '}' || ch == ']';
    }

    private boolean bracketsMatch(char left, char right) {
        return
        (right == ')' && left == '(') ||
        (right == '}' && left == '{') ||
        (right == ']' && left == '[');
    }
}
```

### Second layer of refactoring.

```java
// /Stacks/BalanceExpression.java
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalanceExpression {
    private List<Character> leftBrackets = Arrays.asList('(', '{', '[');
    private List<Character> rightBrackets = Arrays.asList(')', '}', ']');

    public boolean isBalanced(String input) {
        if (input == "")
            return true;

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.empty()) return false;

                var top = stack.pop();
                if (!bracketsMatch(top, ch)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
```

## Implementing a Stack

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.print();
        var top  = stack.pop();
        stack.pop();
        stack.pop();
        // var top  = stack.peek();
        System.out.println(top);
        stack.print();
        System.out.println(stack.isEmpty());
    }
}
```

```java
// My Solution | /Stack/Stack.java
import java.util.Arrays;

public class Stack {
    private int[] stack = new int[5];
    private int count = 0;

    public void push(int input) {
        stack[count++] = input;
    }

    public int pop() {
        return stack[--count];
    }

    public int peek() {
        return stack[count - 1];
    }

    public boolean isEmpty() {
        return count <= 0;
    }

    public void print() {
        for(var i = 0; i < count; i++)
        System.out.println(stack[i]);
    }

}
```

```java
// Mosh Solution
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.toString());
        var top  = stack.pop();
        stack.pop();
        stack.pop();
        // var top  = stack.peek();
        System.out.println(top);
        System.out.println(stack.isEmpty());
    }
}

// Stack.java
import java.util.Arrays;

public class Stack {
    private int[] stack = new int[5];
    private int count = 0;

    public void push(int input) {
        if (count == stack.length)
            throw new StackOverflowError();

        stack[count++] = input;
    }

    public int pop() {
        if (count <= 0)
            throw new IllegalStateException();

        return stack[--count];
    }

    public int peek() {
        if (count <= 0)
            throw new IllegalStateException();

        return stack[count - 1];
    }

    public boolean isEmpty() {
        return count <= 0;
    }

    @Override
    public String toString(){
        var content = Arrays.copyOfRange(stack, 0, count);
        return Arrays.toString(content);
    }
}
```

```java

```
