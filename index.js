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

// var list = new LinkedList();
// list.addLast(5);
// list.addLast(10);
// list.addLast(20);
// list.addFirst(1);

// var list2 = new LinkedList();
// list2.addLast(4);
// list2.addLast(54);
// list2.addFirst(17);

// let arr = new Array();
// arr[0] = list;
// arr[1] = list2;

// console.log(arr);

class HashTable {
  entries = new Array();

  set(key, value) {
    let index = this.hash(key);

    if (!entries[index]) {
      this.entries[index] = new LinkedList();
    }

    let bucket = this.entries[index];
    for (let entry in bucket) {
      if (entry.key == key) {
        entry.value = value;
        return;
      }
    }

    let entry = { key: value };
    bucket.addLast(entry);
  }

  hash(key) {
    return key % 5;
  }
}

let hashTable = new HashTable();
hashTable.set(3, "OK");
hashTable.set(4, "OKe");
hashTable.set(9, "OKd");

console.log(hashTable);
