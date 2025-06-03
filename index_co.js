// Node for LinkedList
class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

// Singly Linked List
class LinkedList {
  constructor() {
    this.head = null;
  }

  // Add node to end
  add(value) {
    const newNode = new Node(value);
    if (!this.head) {
      this.head = newNode;
      return;
    }

    let current = this.head;
    while (current.next) {
      current = current.next;
    }

    current.next = newNode;
  }

  // Find a node by key
  find(key) {
    let current = this.head;
    while (current) {
      if (current.value.key === key) {
        return current.value;
      }
      current = current.next;
    }
    return null;
  }

  // Remove a node by key
  remove(key) {
    if (!this.head) return;

    if (this.head.value.key === key) {
      this.head = this.head.next;
      return;
    }

    let current = this.head;
    while (current.next) {
      if (current.next.value.key === key) {
        current.next = current.next.next;
        return;
      }
      current = current.next;
    }
  }

  // Update a value by key
  update(key, newValue) {
    let current = this.head;
    while (current) {
      if (current.value.key === key) {
        current.value.value = newValue;
        return true;
      }
      current = current.next;
    }
    return false;
  }

  // Iterate using a generator
  *[Symbol.iterator]() {
    let current = this.head;
    while (current) {
      yield current.value;
      current = current.next;
    }
  }
}

// HashTable using LinkedList for collision handling
class HashTable {
  constructor(size = 5) {
    this.buckets = new Array(size);
  }

  hash(key) {
    // Simple numeric hash function
    if (typeof key === "number") return key % this.buckets.length;
    let hash = 0;
    for (let char of String(key)) {
      hash += char.charCodeAt(0);
    }
    return hash % this.buckets.length;
  }

  set(key, value) {
    const index = this.hash(key);

    if (!this.buckets[index]) {
      this.buckets[index] = new LinkedList();
    }

    const bucket = this.buckets[index];

    // Try to update if key already exists
    if (!bucket.update(key, value)) {
      // Else add new entry
      bucket.add({ key, value });
    }
  }

  get(key) {
    const index = this.hash(key);
    const bucket = this.buckets[index];
    if (!bucket) return null;

    const entry = bucket.find(key);
    return entry ? entry.value : null;
  }

  remove(key) {
    const index = this.hash(key);
    const bucket = this.buckets[index];
    if (!bucket) return;

    bucket.remove(key);
  }

  print() {
    for (let i = 0; i < this.buckets.length; i++) {
      const bucket = this.buckets[i];
      if (bucket) {
        console.log(`Bucket ${i}:`);
        for (const entry of bucket) {
          console.log(`  ${entry.key}: ${entry.value}`);
        }
      }
    }
  }
}

// Example usage
const table = new HashTable();

table.set("name", "Alice");
table.set("age", 30);
table.set("city", "Dhaka");
table.set("job", "Engineer");
table.set("email", "alice@example.com");

console.log("Name:", table.get("name")); // Alice
console.log("Email:", table.get("email")); // alice@example.com

table.remove("age");
console.log("Age:", table.get("age")); // null

table.print();
