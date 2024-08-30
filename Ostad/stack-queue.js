function Stack() {
  return {
    i: 0,
    s: [],

    push: function (item) {
      this.s[this.i++] = item;
    },

    pop: function () {
      if (this.i <= 0) return "Stack is empty";

      return this.s[--this.i];
    },

    peek() {
      // This type of function declaration is also valid
      if (this.i <= 0) return "Stack is empty";

      return this.s[this.i - 1];
    },
  };
}

let stack = Stack();

stack.push(10);
stack.push(20);
stack.push(30);

// console.log(stack.pop());
// console.log(stack.peek());
// console.log(stack.pop());
// console.log(stack.pop());
// console.log(stack.pop());

// Buiding Queue
function Queue() {
  return {
    i: 0,
    j: 0,
    q: [],

    enqueue(item) {
      this.q[this.j++] = item;
    },

    dequeue() {
      if (this.i >= this.j) return "Queue is empty";

      return this.q[this.i++];
    },
  };
}

let queue = Queue();
queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);

console.log(queue.dequeue());
console.log(queue.dequeue());
console.log(queue.dequeue());
console.log(queue.dequeue());
console.log(queue.dequeue());
