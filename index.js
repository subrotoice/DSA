class HashTable {
  constructor(size) {
    this.entries = new Array(size); // size of the table
  }

  set(key, value) {
    let index = this._hash(key);

    if (!this.entries[index]) {
      this.entries[index] = new LinkedList();
    }

    let bucket = this.entries[index];

    let entry = this.getEntry(key);
    if (entry !== null) {
      entry.value = value;
      return;
    }

    entry = { key, value };
    bucket.addLast(entry);
  }

  get(key) {
    let entry = this.getEntry(key);

    return entry === null ? entry : entry.value;
  }

  remove(key) {
    let entry = this.getEntry(key);
    if (entry == null) throw new Error("IllegalStateException");

    this.getBucket(key).remove(entry);
  }

  getBucket(key) {
    return this.entries[this._hash(key)];
  }

  getEntry(key) {
    let bucket = this.getBucket(key);

    if (bucket !== null) {
      for (let entry of bucket) {
        if (entry.key === key) {
          return entry;
        }
      }
    }

    return null;
  }

  _hash(key) {
    // private method
    return key % this.entries.length;
  }
}

let hashTable = new HashTable(5);
hashTable.set(3, "OK-3");
hashTable.set(4, "OK-4");
hashTable.set(9, "OK-9");
hashTable.set(13, "OK-13");

console.log(hashTable.get(9));
console.log(hashTable.get(3));
console.log(hashTable.get(4));
console.log(hashTable.get(13));
hashTable.remove(9);
hashTable.remove(4);
// hashTable.remove(44);
console.log(hashTable.get(9));
console.log(hashTable.get(4));
console.log(hashTable.get(13));
