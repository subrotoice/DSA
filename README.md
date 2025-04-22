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
// Declaration: type[] arrayName

int[] myArray; // int array {1, 3, 5, 7}
String[] myStringArray; // String array {"Hello", "World", "Java"}
char[] wordArray = word.toCharArray(); // String to char array {a, b, d, z}

// Instantiation
myArray = new int[10]; // array of 10 integers
myStringArray = new String[5]; // array of 5 strings

// Declaration + Instantiation
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

_Remember: Here one node just keep track of next node. If you change next of next node then the chain of the head will also change_

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

        System.out.println(Arrays.toString(array));  // [50, 10, 20, 30]
        System.out.println(list); // [50, 10, 20, 30] It print like array

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

    public void removeLast() { // 5, 10, 20
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            return;
        }

        var previous = findPrevious(last);
        last = previous;
        last.next = null;

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
## JavaScript Linked List Implementation
```js
class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.first = null;
    this.last = null;
    this.size = 0;
  }

  // addLast
  addLast(item) {
    let node = new Node(item);

    if (this.first == null) this.first = this.last = node;
    else {
      this.last.next = node; // Call stack er next
      this.last = node; // last property of this object
    }

    this.size++;
  }
  addFirst(item) {
    let node = new Node(item);

    if (this.isEmpty()) this.first = this.last = node;
    else {
      node.next = this.first;
      this.first = node;
    }

    this.size++;
  }

  removeFirst() {
    if (this.isEmpty()) throw new Error("NoSuchElementException");

    if (this.first === this.last) this.first = this.last = null;
    else {
      let second = this.first.next;
      this.first.next = null;
      this.first = second;
    }

    this.size--;
  }

  removeLast() {
    if (this.isEmpty()) throw new Error("NoSuchElementException");

    if (this.first === this.last) {
      this.first = this.last = null;
    } else {
      let previous = this.findPrevious(this.last);
      this.last = previous;
      this.last.next = null;
    }

    this.size--;
  }

  contains(item) {
    return this.indexOf(item) !== -1;
  }

  indexOf(item) {
    let index = 0;
    let current = this.first;

    while (current !== null) {
      if (current.value === item) return index;
      current = current.next;
      index++;
    }

    return -1;
  }

  findPrevious(node) {
    let current = this.first;

    while (current !== null) {
      if (current.next === node) return current;
      current = current.next;
    }

    return null;
  }

  printList() {
    let listToArr = [];
    let current = this.first;

    while (current) {
      listToArr.push(current.value);
      current = current.next;
    }
    console.log(listToArr);
  }

  isEmpty() {
    return this.first == null;
  }
}

var list = new LinkedList();
list.addLast(5);
list.addLast(10);
list.addLast(20);
list.addFirst(1);
list.printList();
list.removeLast();
list.removeFirst();
list.printList();
```
## Using ListNode Constructor function and prototype
```js
function Node(value) {
  this.value = value;
  this.next = null;
}

function LinkedList() {
  this.first = null;
  this.last = null;
  this.size = 0;
}

LinkedList.prototype.isEmpty = function () {
  return this.first === null;
};

LinkedList.prototype.addLast = function (item) {
  var node = new Node(item);

  if (this.first === null) this.first = this.last = node;
  else {
    this.last.next = node;
    this.last = node;
  }

  this.size++;
};

LinkedList.prototype.printList = function () {
  var listToArr = [];
  var current = this.first;

  while (current) {
    listToArr.push(current.value);
    current = current.next;
  }

  console.log(listToArr);
};

// Usage
var list = new LinkedList();
list.addLast(5);
list.addLast(10);
list.addLast(20);
list.printList();
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
## Javascript: Reverse
With checking all edge cases.
```js
reverse() {
if (this.isEmpty) return;

// 10->20->30->40->50
let head = this.first;
let p = head; // 10
let c = head.next; // 20
let next = c.next; // 30

while (next != null) {
    c.next = p;
    p = c;
    c = next;
    next = c.next;
}

head.next = null;
this.last = head;

c.next = p;
this.first = c;
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
## Javascript: Kth node from the end
```js
getKthFromTheEnd(k) {
  if (this.isEmpty()) throw new Error("Illegal state");
  if (k < 1) throw new Error("Invalid value of k");

  let first = this.first;
  let second = first;

  for (let i = 0; i < k - 1; i++) {
    second = second.next;
    if (second == null) throw new Error("Illegal Argument");
  }

  while (second != this.last) {
    second = second.next;
    first = first.next;
  }

  return first.value;
}
```

# Stacks - Last In First Out (LIFO)

Internally we use array or linked lists to store the object in a stack. So stack is the wrapper of array or linked lists which gives us different way of storing and accessing object.

- Implement the undo feature
- Build Navigation

![https://prnt.sc/B40St89n5LaX](https://cdn.pixabay.com/photo/2016/03/31/19/16/book-1294864_1280.png)

```javascript
let arr = [1, 2, 3, 4, 5];

// Stack: Insert from last, Pop from Last (Stack Of Desh)
arr.push(7); // Stack/Queue [1, 2, 3, 4, 5, 7]
arr.pop(); // Stack [1, 2, 3, 4, 5]

// Queue: Insert from Last, Pop from first (People stand in line)
arr.push(7); //  Stack/Queue: Enqeue
arr.shift(); // Queue: Dequeue
```

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
## JavaScript Stack using array push/pop method
```js
let stack = [];
stack.push(10);
stack.push(20);
stack.push(30);
stack.push(40);
console.log(stack); // [ 10, 20, 30, 40 ]
console.log(stack.pop()); // 40
console.log(stack); // [ 10, 20, 30 ]
```
## JavaScript Stack: Reverse string
```js
let str = "abcde";
let revStr = [];

for (let i = 0; i < str.length; i++) {
  revStr.push(str.charAt(i));
}

while (revStr.length != 0) {
  console.log(revStr.pop());
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

# Queues

![https://prnt.sc/dXcCM65gJWCG](https://media.geeksforgeeks.org/wp-content/uploads/20220816162225/Queue.png)

## Application

- Printers
- Operation Systems
- Web Server
- Live support systems

## Operations

- Enqueue
- Dequeue
- Peek
- isEmpty
- isFull

## Java Queue

```java
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        var front = queue.remove();
        System.out.println(front);
        System.out.println(queue);
    }
}
```
## JavaScript Queue: push/shift
```js
let queue = [];
queue.push(10);
queue.push(20);
queue.push(30);
queue.push(40);
console.log(queue); // [ 10, 20, 30, 40 ]
console.log(queue.shift()); // 10
console.log(queue); // [ 20, 30, 40 ]
```

## Exercise: Reversiong a Queue (Queue: [10, 20, 30] keep it in Stack [10, 20, 30] and then keep it back to Queue [30, 20, 10])

**Here build in Main class**

```java
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        reverse(queue);

        System.out.println(queue);
    }

    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.empty())
            queue.add(stack.pop());
    }
}
```

## JavaScript: Reverse Queue
```js
let queue = [];
let stack = [];
queue.push(10);
queue.push(20);
queue.push(30);
queue.push(40);
console.log(queue); // [ 10, 20, 30, 40 ]

while (queue.length !== 0) {
  stack.push(queue.shift());
}

while (stack.length !== 0) {
  queue.push(stack.pop());
}

console.log(queue); // [ 40, 30, 20, 10 ]
```

## Exercise: Building a Queue Using an Array

### Build in 3 ways

1. Array
2. LinkedList
3. Stack

```java
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue(12);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
        var front = arrayQueue.dequeue();
        arrayQueue.dequeue();
        // arrayQueue.dequeue();

        System.out.println("Front: " + front);
        System.out.println(arrayQueue.isEmpty());
        System.out.println("Total items: " + arrayQueue.count());
        System.out.println(arrayQueue.toString());
    }

}
```

```java
// My Solution
// Queue/ArrayQueue.java
import java.util.Arrays;

public class ArrayQueue {
    private int[] queue = new int[5];
    private int front = 0;
    private int rear = 0;

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException();

        queue[rear++] = item;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        return queue[front++];
    }

    public int peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        // System.out.println(front);
        // System.out.println(rear);
        return front >= rear;
    }

    public boolean isFull() {
        return queue.length <= rear;
    }

    public int count() {
        return rear - front;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(queue, front, rear);
        return Arrays.toString(content);
    }

}
```

## Using circular array (Mosh)

![https://prnt.sc/dh7QzRXZ7lR3](https://scanftree.com/Data_Structure/circularqueues.png)
![https://prnt.sc/kLrrV1NIOCxC](https://www.simplilearn.com/ice9/free_resources_article_thumb/Circular_incrementation_in_Circular_queue.png)

```java
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue(12);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
        var front = arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.enqueue(60);
        arrayQueue.enqueue(70);

        System.out.println("Front: " + front);
        System.out.println(arrayQueue.isEmpty());
        System.out.println("Total items: " + arrayQueue.count());
        System.out.println(arrayQueue.toString());

    }
}
```

- Here is proper way of object oriented programming. Constructer er return type thake na.

```java
// /Queue/ArrayQueue.java
import java.util.Arrays;

public class ArrayQueue {
    private int[] queue;
    private int front = 0;
    private int rear = 0;
    private int count = 0;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
    }


    public void enqueue(int item) {

        if (queue.length <= count)
            throw new IllegalStateException();

        queue[rear] = item;
        rear = (rear+1) % queue.length;
        count++;
        System.out.println(count);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        var item = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        count--;
        System.out.println(count);
        return item;
    }

    public int peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        return count == 0;
        // return front >= rear;
    }

    public boolean isFull() {
        return queue.length <= rear;
    }

    public int count() {
        return count;
    }

    @Override
    public String toString() {
        // var content = Arrays.copyOfRange(queue, front, rear);
        return Arrays.toString(queue);
    }

}
```

## Exercise: Building a Queue Using Stacks

- Here use two stack, stack1 and stack2. stack1 is using for enqueue and for dequeue copy from stack1 to stack2 then pop.
- stack1 [10, 20, 30], so stack2 [30, 20, 10] if pop from stack2 we get 10 which is actual queue front

```java
// Main.java
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        QueueWIthTwoStacks queueWIthTwoStacks = new QueueWIthTwoStacks();

        queueWIthTwoStacks.enqueue(10);
        queueWIthTwoStacks.enqueue(20);
        queueWIthTwoStacks.enqueue(30);

        var frontPeek = queueWIthTwoStacks.peek();
        System.out.println(frontPeek);
    }

}

// /Queue/QUeueWithTwoStacks.java
import java.util.Stack;

public class QueueWIthTwoStacks {
    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> stack2 = new Stack();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        moveStack1ToStack2();

        return stack2.pop();
    }

    public int peek() {
        moveStack1ToStack2();

        return stack2.peek();
    }

    private void moveStack1ToStack2() {
        if (isEmpty())
        throw new IllegalArgumentException();

        if(stack2.empty())
            while (!stack1.empty())
                stack2.push(stack1.pop());
    }

    public boolean isEmpty() {
            return stack1.empty() && stack2.empty();
    }
}
```

## Priority Queue

```java
// Java Library
import java.util.PriorityQueue;
public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(2);

        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.remove()); // 1, 2, 3, 5 By default smallest number will come out first

    }
}
```

## Exercise: Building a Priority Queue

```java
// My Solution,
// Main.java
public class Main {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);

        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(5);
        priorityQueue.add(7);
        priorityQueue.add(2);

        System.out.println(priorityQueue.toString());

    }

}

//PriorityQueue.java
import java.util.Arrays;

public class PriorityQueue {
    private int[] queue;
    private int count = 0;

    public PriorityQueue(int capacity) {
        queue = new int[capacity];
    }


    public void add(int item) {
        if (count == queue.length)
            throw new IllegalStateException();

        if (count == 0) {
            queue[0] = item;
            count++;
            return;
        }

        // [1, 3, 5, 7] insert(2)
        // [1, 3, 3, 5, 7] insert(2)
        // [0, 1, 2, 3, 4] insert(2)
        var limit = count - 1;
        // Shifting Items
        while (limit >= 0) {
            if(queue[limit] < item) // 1 < 2
                break;

            queue[limit + 1] = queue[limit--];
        }

        queue[limit + 1] = item;
        count++;
    }

    @Override
    public String toString() {
        System.out.println("Count: " + count);
        return Arrays.toString(queue);
    }

}
```

- Refactoring some code. Select code -> Right click -> Move to Method

```java
//Main.java (Mosh + MySolution)
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

// ProirityQueue.java
import java.nio.channels.IllegalSelectorException;
import java.util.Arrays;

public class PriorityQueue {
    private int[] queue;
    private int count = 0;

    public PriorityQueue(int capacity) {
        queue = new int[capacity];
    }

    public void add(int item) {
        if (isFull())
            throw new IllegalStateException();

        int i = shiftItemsToInsert(item);

        queue[i] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        // [1, 3, 5, 7] insert(2)
        // [1, 3, 3, 5, 7] insert(2)
        // [0, 1, 2, 3, 4] insert(2)
        int i;
        // Shifting Items
        for(i = count - 1; i >= 0; i--) {
            if(queue[i] < item) // 1 < 2
                break;

            queue[i + 1] = queue[i];
        }

        return i + 1;
    }

    public int remove() {
        if(isEmpty())
            throw new IllegalSelectorException();

        int temp = queue[0];
        for(int i = 0; i <= count - 2; i++)
            queue[i] = queue[i + 1];

        queue[count - 1] = 0;
        count --;
        return temp;
    }

    public boolean isFull() {
        return count == queue.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        System.out.println("Count: " + count);
        return Arrays.toString(queue);
    }

}
```

# Hash Table (Maps, Sets are implemented by HashTable)

**HashTable (key:value) pair, where Key management is the challenge. Value is not an issue**

- Very fast look up
  Different language it know as different names
- Java - HashMap
- Javascript - Object
- Python - Dictonary
- C# - Dictonary

## Java HashTable / HashMap

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Subroto");
        map.put(2, "Goutom");
        map.put(3, "Jonny");

        var name = map.get(2);
        System.out.println(name);

        for(var item: map.keySet())
            System.out.println(map.get(item));

        for(var item: map.entrySet())
            System.out.println(item.getValue());
    }
}
```

## Exercise: First Non-repeated Character

- main and implementing method are on same Class

```java
// Main.java, My Solution:- "a reen apple"
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = "a green apple";
        System.out.println(firstNonRepeatedCharacter(str));
    }

    public static char firstNonRepeatedCharacter(String input) {
        Map<Character, Integer> map = new HashMap<>();

        var chars = input.toCharArray();
        for(char ch:chars){
/*             var charCount = map.get(ch);
            if (charCount == null)
                count = 1;
            else count++; */

            var charCount = map.containsKey(ch) ? map.get(ch) : 0;

            map.put(ch, ++ charCount);
        }

        for(char ch:chars) {
            if (map.get(ch) == 1)
                return ch;
        }

        return '0';
    }
}
```

**NB: Mosh solution is near to me**

## Sets

- Maps: key -> value
- Sets: key (Don't allow duplicate)

## Java Sets

```java
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int[] numbers = {1, 2, 3, 3, 4, 5, 5, 6};

        for(int number: numbers)
            set.add(number);

        System.out.println(set);

        // Some other methods
        System.out.println(set.contains(6));
        set.remove(3);
        set.clear();

        System.out.println(set);
    }
}
```

## Exercise: First Repetaed Character

- Here use map, Because we don't need to keep frequency, just need to watch is it present or not.

```java
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        CharFinder charFinder = new CharFinder("a green apple");

        var firstRepetedChar = charFinder.findFirstRepetedCharacter();
        System.out.println(firstRepetedChar);
    }
}

// CharFinder.java
import java.util.HashSet;
import java.util.Set;

public class CharFinder {
    private String input;

    public CharFinder(String str) {
        input = str;
    }

    public char findFirstRepetedCharacter() {
        Set<Character> set = new HashSet<>();
        for(char ch : input.toCharArray()) {
            if (set.contains(ch))
                return ch;
        set.add(ch);
        }

        // return '0';
        return Character.MIN_VALUE; // If nothing find (Mosh)
    }

}
```

## Hash Function

A hash function is a function that accepts a group of characters (key) and maps that key to a value of a certain length (called a hash value or hash). The process is called hashing. <br >
It is done for indexing and locating items in databases. It provides an easy way to find longer value associated with the shorter hash value. It is widely used in encryption. It is also known as a hashing algorithm or message digest function.

- Basic form

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(hash(3543)); // output: 43
        System.out.println(hash("A-3543")); // output: 17
    }

    // Very basic hash function which fit to an array[100]
    public static int hash(int number) {
        return number % 100;
    }

    // Bit advance hash function, combine ascii value
    public static int hash(String key) {
        int hash = 0;
        for(char ch: key.toCharArray())
            hash += ch; // auto converted to int

        return hash % 100;
    }
}
```

Here output: 43 and 17 is hash value. In criptography it is index value. In DSA / HashTable it is index value or hash value.

## Java hashCode

```java
public class Main {
    public static void main(String[] args) {
        String str = "orange";
        var output = str.hashCode()
        System.out.println(output); // output: -1008851410
    }

}
```

## Collisions: when two distinct pieces of data in a hash table share the same hash value.

![https://prnt.sc/Q6WionD4xbmh](https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Hash_table_4_1_1_0_0_1_0_LL.svg/640px-Hash_table_4_1_1_0_0_1_0_LL.svg.png)
Two ways to handel collision

1. Chaining: Each cell in an array point to link list. Do not store value itself store linklist
2. Open Addressing: There are some open addressing algorithm.

### Chaining

![https://prnt.sc/sJOAr6t5PwuL](https://scaler.com/topics/images/separate-chaining-hash-table)

### Open Addressing

When a collision occurs in HashTable, open addressing finds the next available slot within the table itself using a probing sequence.

#### Linear Probing(Searching): hash(key) + i // i = 1, 2, 3, 4, 5

- It is possible i may get larger boundary of an array, so always reduce it by mod size of the array
  New Index = (hash(key) + i) % table_size

#### Quadratic Probing: hash(key) + i\*i // i = 1, 4, 9, 16, 25

New Index = (hash(key) + i\*i) % table_size

#### Double Hashing: hash(key) + i\*i // 1, 4, 9, 16, 25

![https://prnt.sc/gVgM613qu9D3](https://i.postimg.cc/wTmLQqDZ/Double-Hashing2.png)
![https://prnt.sc/jDn9kNMhP43z](https://i.postimg.cc/SsQtnjgR/Double-Hashing.png)

```java
hash1(key) = key % table_size
hash2(key) = prime - (key % prime)
index = (hash1 + i*hash2) % size
```

NB: Prime number should be smaller then the table size, mod by size to reduce size and fit into an array. <br >
Example

```java
K = 11, V = C // Key, Value

hash1(11) = 11 % 5 = 1 // Array size: 5 [index: 0, 1, 2, 3, 4]
hash2(11) = 3 - (11 % 3) = 1 // Prime number less then 4
index = (1 + 1*1) % 5 = 2 // When slot: 2 is full then increase i: 2, 3, 4 to find empty location
```

## Exercise: Building a Hash Table

```java
// Main.java
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
        System.out.println(table.get(6));
        // System.out.println(table.get(8));
    }
}
```

- Very tricky here: LinkedList[] it is LinkedList array. like int array: int[], char[]
- This array contain Entry class instance / object. Entities is array name and size is 5.
- Later on we will create instance of this class for each eteration.
- Passing key to find the bucket mean index in array that contains Linkedlist.

```java
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
        var index = hash(key);

        if(entries[index] == null)
            entries[index] = new LinkedList<>();

        var bucket = entries[index];

        for(var entry: bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        // Entry entry = new Entry(key, value);
        bucket.addLast(new Entry(key, value));
    }

    public String get(int key) {
        var index = hash(key);
        var bucket = entries[index];
        if (bucket != null)
            for(var entry : bucket)
                if (entry.key == key)
                    return entry.value;

        return null;
    }

    public void remove(int key) {
        var index = hash(key);
        var bucket = entries[index];

        if (bucket == null)
            throw new IllegalStateException();

        for(var entry : bucket)
            if (entry.key == key) {
                bucket.remove(entry);
                return;
            }

        throw new IllegalStateException();
    }

    private int hash(int key) {
        return key % entries.length;
    }

}
```

## Refactoring

- Best refactoring ever.

```java
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
```

# Algorithms

1. Searching
2. Sorthing
3. String Manipulation

## Sorting

1. Bubble Sort
2. Selection Sort
3. Insertion Sort
4. Merge Sort
5. Quick Sort
6. Counting Sort
7. Bucket Sort

### Bubble Sort

```java
// BubbleSort.java
public class BubbleSort {
    // [0, 1, 2, 3, 4]
    // [8, 4, 5, 9, 2]
    public void sort(int[] input) {
        int length = input.length;
        boolean isShorted;

        for(var i = 0; i < length; i++) {
            isShorted = true;
            for(var j = 0; j < length - i - 1; j++)
                if (input[j] > input[j + 1]) {
                    isShorted = false;
                    swap(input, j);
                }
                if (isShorted)
                    return;

        }

    }

    private void swap(int[] input, int j) {
        var temp = input[j];
        input[j] = input[j + 1];
        input[j + 1] = temp;
    }
}

// Main.java - Call
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myArray = {8, 4, 5, 9, 2, 7};
        // BubbleSort bubbleSort = new BubbleSort();
        var sorter = new BubbleSort();
        System.out.println(Arrays.toString(myArray));
        sorter.sort(myArray);
        System.out.println(Arrays.toString(myArray));

    }

}

```

### Selection Sort

![https://prnt.sc/NF6khQy3cYis](https://www.boardinfinity.com/blog/content/images/2023/03/Selection-sort.png)

1. **Divide the list into two parts**: the sorted part at the left end and the unsorted part at the right end. Initially, the sorted part is empty and the unsorted part is the entire list.
2. **Find the minimum element** in the unsorted part of the list.
3. **Swap** the minimum element with the first element of the unsorted part, moving it to the end of the sorted part.
4. **Repeat** the process for the remaining unsorted part of the list.

The steps continue until the entire list is sorted.

```java
// Selection Sort
public class SelectionSort {
/*  [0, 1, 2, 3, 4]
    [8, 2, 4, 1, 3] */
    public void sort (int[] input) {
        int lenght = input.length;
        for(int i = 0; i < lenght; i++) {
            var minIndex = getMinIndex(input, lenght, i);

            swap(input, i, minIndex);

        }
    }

    private int getMinIndex(int[] input, int lenght, int i) {
        var minIndex = i;
        for(int j = i; j < lenght; j++)
            if (input[minIndex] > input[j])
                minIndex = j;
        return minIndex;
    }

    private void swap(int[] input, int i, int minIndex) {
        if(i == minIndex) return;

        var temp = input[minIndex];
        input[minIndex] = input[i];
        input[i] = temp;
    }

}

// Main.java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myArray = {8, 4, 5, 9, 2, 7};
        // BubbleSort bubbleSort = new BubbleSort();
        var sorter = new SelectionSort();
        System.out.println(Arrays.toString(myArray));
        sorter.sort(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}
```

### Insertion Sort

It works similarly to how you might sort playing cards in your hands.

### How it Works

1. **Start with the second element** (since a single element is trivially sorted).
2. **Compare the current element** with the elements in the sorted part of the array.
3. **Shift elements** of the sorted part to the right to make space for the current element.
4. **Insert the current element** into the correct position.
5. **Repeat** until the whole array is sorted.

### Example

Consider sorting the array `[12, 11, 13, 5, 6]`:

1. **Initial array**: `[12, 11, 13, 5, 6]`
2. **First pass**: Take the second element `11`. Compare it with `12` and place `11` before `12`: `[11, 12, 13, 5, 6]`.
3. **Second pass**: Take `13`. It is already in the correct position: `[11, 12, 13, 5, 6]`.
4. **Third pass**: Take `5`. Place it before `11`: `[5, 11, 12, 13, 6]`.
5. **Fourth pass**: Take `6`. Place it before `11`: `[5, 6, 11, 12, 13]`.

Insertion sort is efficient for small data sets and mostly sorted arrays. It is less efficient on large lists compared to more advanced algorithms like quicksort, mergesort, or heapsort.

```java
public class InsertionSort {
    /*  [0, 1, 2, 3, 4]
        [8, 2, 4, 1, 3] */
    public void sort(int[] input) {
        var length = input.length;
        for(var i = 1; i < length; i++) {
            var current = input[i];
            int j = i;
            while (j > 0 && input[j - 1] > current) {
                input[j] = input[j - 1];
                j--;
            }
            input[j] = current;
        }
    }
}
```

## Marge Sort

Merge sort is a comparison-based, divide-and-conquer sorting algorithm. It divides the input array into smaller sub-arrays, sorts those sub-arrays, and then merges them back together to produce a sorted array. Here's a detailed explanation:

### How it Works

1. **Divide**: Split the array into two halves.
2. **Conquer**: Recursively sort each half.
3. **Combine**: Merge the two sorted halves into a single sorted array.

```java
public class MargeSort {
    public void sort(int[] array) {
        int length = array.length;
        if (length < 2) return;

        int middle = length / 2;

        int[] left = new int[middle];
        for(var i = 0; i < middle; i++)
            left[i] = array[i];

        int[] right = new int[length - middle];
        for(var i = 0; i < right.length; i++ )
            right[i] = array[middle + i];

        sort(left);
        sort(right);

        marge(left, right, array); // passing "array" most tircky part
    }

    private void marge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < left.length) {
            if(left[i] < right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < left.length)
            result[k++] = left[j++];
    }
}
```

## Quick Sort (pivot)

- Build most language and frameworks
- It does not required any additional space. Sort in-place
- In term of reordering we do not have worring about items in the right partition.

```java
import java.util.Arrays;

public class QuickSort {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }
    public void sort(int[] array, int start, int end) {
        if(start >= end) return;

        var boundary = partition(array, start, end);
        sort(array, start, boundary - 1); // Left part
        sort(array, boundary + 1, end); // right part

    }

    private int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1;

        for(var i = start; i <= end; i++) {
            if (array[i] <= pivot)
                swap(array, ++boundary, i);
        }

        return boundary;
    }

    private void swap(int[] array, int boundary, int i) {
        var temp = array[i];
        array[i] = array[boundary];
        array[boundary] = temp;
    }

}

// Main.java
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] myArray = {7, 3, 1, 5, 2};
        var sorter = new QuickSort();
        System.out.println(Arrays.toString(myArray));
        sorter.sort(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}
```

## Counting Sort (Very easy)

**When to use**

- Allocating extra space is not an issue
- Values are positive integers
- Most of the values in the range are present

```java
import java.util.Arrays;

public class CountingSort {
    public void sort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int[] count = new int[max + 1];

        for(int item: array)
            count[item]++;

        var counter = 0;
        for(int i = 0; i < count.length; i++) {
            for(int j = 0; j < count[i]; j++)
                array[counter++] = i;
        }
    }
}
```

## Bucket Sort

![https://prnt.sc/oIVwa90NZAY8](https://media.geeksforgeeks.org/wp-content/uploads/20230705162234/file.png)

```java
// BucketSort.java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public void sort(int[] array, int numberOfBucket) {
        List<List<Integer>> buckets = createBuckets(array, numberOfBucket);

        var i = 0;
        for(var bucket : buckets) {
            Collections.sort(bucket);
            for(var item : bucket)
                array[i++] = item;
        }
    }

    private List<List<Integer>> createBuckets(int[] array, int numberOfBucket) {
        List<List<Integer>> buckets = new ArrayList<>();

        // List contains another List so it make instance of each inner List
        for(var i = 0; i < numberOfBucket; i++)
            buckets.add(new ArrayList<>());

        for(int item : array){
            // Here get return the index of a bucket. Here each bucket is a linked list of integer
            buckets.get(item / numberOfBucket).add(item);
        }
        return buckets;
    }
}

// Main.java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myArray = {7, 3, 2, 5, 3, 1, 2, 4, 6};
        var sorter = new BucketSort();
        System.out.println(Arrays.toString(myArray));
        sorter.sort(myArray, 3);
        System.out.println(Arrays.toString(myArray));
    }
}
```

# Searching Alogrithms

1. Linear Search
2. Binary Search
3. Ternary Search
4. Jumap Search
5. Exponential Search

## Linear Search

```java
// Main.java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 10, 13, 18};
        var search = new Search();
        // Linear Search
        System.out.println(search.linearSearch(numbers, 18));
    }
}
```

```java
// Search.java
public class Search {
    // linear Search
    public int linearSearch(int[] array, int item) {
        for(var i = 0; i < array.length; i++)
            if (array[i] == item)
                return i;

        return -1;
    }
}

```

## **Binary Search**

- Divide and Conqure
- When we lookup multiple item then it is good to short array first then Binary search.

### Binary Search: Recursive

```java
// Main.java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 10, 13, 18};
        var search = new Search();
        // Linear Search
        // System.out.println(search.linearSearch(numbers, 18));

        // Binary search using Recurssion
        System.out.println(search.binarySearchRec(numbers, 3));
        System.out.println(search.binarySearchItr(numbers, 13));
    }
}

```

```java
// Search.java
public class Search {
    // Binary Search (Recursive)
    // [1, 3, 5, 7, 9]
    public int binarySearchRec(int[] array, int item) {
        return binarySearchRec(array, item, 0, (array.length - 1));
    }

    private int binarySearchRec(int[] array, int item, int left, int right) {
        if (right < left)
            return -1;

        int middle = (left + right) / 2;
        if (array[middle] == item)
            return middle;

        if (array[middle] > item)
            return binarySearchRec(array, item, left, middle - 1);

        return binarySearchRec(array, item, middle + 1, right);
    }

       // [1, 3, 5, 7, 10, 13, 18] 3 (Iterative)
    public int binarySearchItr(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2;
        // System.out.println(middle);
        while (left < right) {
            middle = (left + right) / 2;

            if (array[middle] == target)
                return middle;

            if (target < array[middle])
                right = middle - 1;
            else
                left = middle + 1;

        }

        return -1;
    }
}
```

**NB: Binary search is faster than ternary search**

## **Ternary Search**

- Calculation of partiionSize is important
- partitionSize = (right - left) / 3;

```java
// Main.java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 10, 13, 18};
        var search = new Search();
        System.out.println(search.ternarySearchRec(numbers, 10));
    }
}
```

```java
// Search.java
public class Search {
    public int ternarySearchRec(int[] array, int target) {
       return ternarySearchRec(array, target, 0, array.length-1);
    }

    private int ternarySearchRec(int[] array, int target, int left, int right) {
        if(left > right) return -1;

        int partitionSize = (right-left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (array[mid1] == target) return mid1;
        if (array[mid2] == target) return mid2;

        // Left Partition
        if(array[mid1] > target) return ternarySearchRec(array, target, left, mid1-1);
        // Middle Partition
        if(array[mid1] < target) return ternarySearchRec(array, target, mid1+1, mid2-1);
        // Right Partition
        return ternarySearchRec(array, target, mid2+1, right);
    }
}
```

## **Jump Search**

- Find the block
- Then perform linear search on that block

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 10, 13, 18, 20, 21};
        var search = new Search();
        System.out.println(search.jumpSearch(numbers, 10));
    }
}
```

```java
// Search.java
public class Search {
    // jump search
    // [1, 3, 5, 7, 10, 13, 18, 20, 21]
    public int jumpSearch(int[] array, int target) {
        int length = array.length;
        int blockSize =  (int)Math.sqrt(length);
        int start = 0;
        int next = blockSize;

        while (start < length && array[next - 1] < target ) {
            start = next;
            next += blockSize;

            if (next > array.length)
                next = array.length;
        }

        for(int i = start; i < next; i++)
            if (array[i] == target) return i;

        return -1;
    }
}
```

## **Exponential Search**

- Extend search boudary multiplay by 2. like: 1, 2, 4, 8, 16 (it is the range)
- Target 15, in that case we perform binary search in range of 8 - 16
- Time Complexity O(log i)

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 10, 13, 18, 20, 21};
        var search = new Search();
        System.out.println(search.exponentialSearch(numbers, 21));
    }
}
```

```java
// Search.java
public class Search {
    // Exponential search
    // [1, 3, 5, 7, 10, 13, 18, 20, 21]
    public int exponentialSearch(int[] array, int target) {
        int length = array.length;
        int bound = 1;

        while (bound < length && array[bound] < target ) {
            bound *= 2;
        }

        var left = bound / 2;
        var right = Math.min(bound, length-1);

        return binarySearchRec(array, target, left, right);
    }
}
```

# **String Manipulation**

## Count Vowels

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        var countVowels = StringUtils.countVowels(null);
        System.out.println(countVowels);
    }
}
```
```java
// StringUtils.java
public class StringUtils {
    public static int countVowels(String str) {
        if(str == null) return 0;
        
        int count = 0;
        String vowels = "aeiou";
        for(var ch:str.toLowerCase().toCharArray())
            if(vowels.indexOf(ch) != -1)
                count++;

        return count;
    }
}

// Reverse String
public static String reverseString(String str) {
    var length = str.length();
    if(length < 2) return str;
    int count = 0;

    String reversed = "";
    for(var i = length - 1; i >= 0; i--) // O(n) operation
        reversed += str.charAt(i);// O(n) operation

    return reversed;
}


// Reverse String useing String Builder
public static String reverseString(String str) {
    var length = str.length();
    if(length < 2) return str;
    int count = 0;

    StringBuilder reversed = new StringBuilder();
    for(var i = length - 1; i >= 0; i--) // O(n) operation
        reversed.append(str.charAt(i)); // O(1) operation

    return reversed.toString();
}

// Reverse Words in a sentesce | Trees are beautiful -> beautiful are Trees
public static String reverseWords(String sentence) {
    if(sentence == null) return "";

    String[] words = sentence.split(" ");
    StringBuilder reversed = new StringBuilder();
    for(var i=words.length - 1; i >= 0; i--) {
        reversed.append(words[i] + " ");
    }

    return reversed.toString().trim(); // remove white space using trim()
}
```


## Rest all String Manipulation

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        // var countVowels = StringUtils.countVowels(null);
        // var reversed= StringUtils.reverseString("Hellow World");
        // var reversed= StringUtils.reverseWords("Hellow World");
        // System.out.println(StringUtils.capitalize(""));
        // System.out.println(StringUtils.areAnagrams("ABCD", "BCDF"));
        System.out.println(StringUtils.isPalindrome("ABBa"));
    }
}

```
```java
// StringUtils.java
import java.util.Arrays;

public class StringUtils {
    // Count Vowles
    public static int countVowels(String str) {
        if(str == null) return 0;
        
        int count = 0;
        String vowels = "aeiou";
        for(var ch:str.toLowerCase().toCharArray())
            if(vowels.indexOf(ch) != -1)
                count++;

        return count;
    }

    // Reverse String
    public static String reverseString(String str) {
        var length = str.length();
        if(length < 2) return str;
        int count = 0;

        StringBuilder reversed = new StringBuilder();
        for(var i = length - 1; i >= 0; i--)
            reversed.append(str.charAt(i)); // O(1) operation

        return reversed.toString();
    }
    
    // Reverse Words in a sentesce | Trees are beautiful -> beautiful are Trees
    public static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversed = new StringBuilder();
        for(var i=words.length - 1; i >= 0; i--) {
            reversed.append(words[i] + " ");
        }

        return reversed.toString().trim();
    }
    
    // Capitalized Sentence | Trees are beautiful -> Trees Are Beautiful
    public static String capitalize(String sentence) {
        if(sentence == null || sentence.trim().isEmpty()) return "";

        String[] words = sentence.trim().replaceAll(" +", " ").split(" ");

        for(var i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    // Ana Grams | ABCD -> BACD
    public static boolean areAnagrams(String first, String second) {
        if(first == null || second == null) return false;

        var array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    // Palandrom | ABBA, MADAM | It involves a lot of operation
    public static boolean isPalindromeWithLibrary(String word) {
        if(word == null) return true;

        var input = new StringBuilder(word);
        input.reverse();
        return input.toString().equals(word);
    }

    // Palandrom | ABBA, MADAM | It O(n/2)
    public static boolean isPalindromeWithCharArray(String word) {
        if(word == null) return true;

        char[] wordArray = word.toCharArray();
        var left = 0;
        var right = word.length() - 1;

        while (left < right) {
            if (wordArray[left] != wordArray[right] )
                return false;
            
            left++; 
            right--; 
        }

        return true;
    }

    // Palandrom | ABBA, MADAM | It O(n/2) | charAt
    public static boolean isPalindrome(String word) {
        if(word == null) return false;

        var lowerCaseWord = word.toLowerCase();
        var left = 0;
        var right = lowerCaseWord.length() - 1;

        while (left < right) 
            if (lowerCaseWord.charAt(left++) != lowerCaseWord.charAt(right--))
                return false;
    
        return true;
    }
}
```

