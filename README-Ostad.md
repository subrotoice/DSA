# Ch-1: Array Problem Solving

**Taking input in JavaScript: Ostad**

```javascript
// Rotate The Array
function main(input) {
  const lines = input.split("\r\n");
  const textMetaData = lines[0];
  const textData = lines[1];

  const metaData = textMetaData.split(" ");
  const n = Number(metaData[0]);
  const k = Number(metaData[1]);

  const data = textData.split(" ");

  if (k === 0) {
    const temp = data[n - 1];
    for (let i = n - 1; i > 0; i--) {
      data[i] = data[i - 1];
    }
    data[0] = temp;
  } else if (k === 1) {
    const temp = data[0];
    for (let i = 0; i < n - 1; i++) {
      data[i] = data[i + 1];
    }
    data[n - 1] = temp;
  }

  const output = data.join(" ");
  console.log(output);
}

let input = "";
process.stdin.on("data", (chunk) => {
  input += chunk;
});

process.stdin.on("end", () => {
  main(input.trim());
});
```

**Find Duplicate [See](https://codemama.io/codetest/participate/5e4cd069-90e3-450b-be7d-9234ac1b5d5d/problems/find-duplicate)**

```java
function main (input) {
    const [n, textData] = input.split("\r\n");
    const data = textData.split(" ");

    for(let i=0; i<n-1; i++) {
        for(let j=i+1; j<n; j++ ) {
            if(data[i]==data[j]){
                console.log(data[i]);
                return 0;
            }

        }
    }

}
```

# Recursion

## Exercise: Triangle Reverse

```javascript
/* [48]
[20, 28]
[8, 12, 16]
[3, 5, 7, 9]
[1, 2, 3, 4, 5] */
function triangle(arr) {
  var arrLenght = arr.length;
  if (arrLenght == 1) {
    console.log(arr);
    return arr;
  }

  var ans = [];
  for (var i = 0; i < arrLenght - 1; i++) {
    ans[i] = arr[i] + arr[i + 1];
  }

  triangle(ans);
  console.log(arr);
}

triangle([1, 2, 3, 4, 5]);
```

## Min and Max element of an array

```javascript
let arr = [5, 6, 1, 24, 9, 2];
let arrLenght = arr.length;

console.log(arrMin(arr, arrLenght));
console.log(arrMax(arr, arrLenght));

function arrMin(arr, n) {
  if (n == 1) return arr[0];

  return Math.min(arr[n - 1], arrMin(arr, n - 1));
}

function arrMax(arr, n) {
  if (n == 1) return arr[0];

  return Math.max(arr[n - 1], arrMax(arr, n - 1));
}
```

# LinekdList

[876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list)

```js
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var middleNode = function (head) {
  if (head == null || head.next == null) return head;

  let count = 0;
  let current = head;
  while (current != null) {
    current = current.next;
    count++;
  }

  let middle = Math.floor(count / 2); // 2, 3
  current = head;
  while (middle--) current = current.next;

  return current;
};
```

Another Way, Two Pointer (Optimized)

```js
//Walk Through 1>2>3>4>5>6: f:1 s:1, f:3, s:2, f:5 s:3
var middleNode = function (head) {
  if (head == null || head.next == null) return head;

  let slow = head;
  let fast = head;
  console.log(fast.next.val);
  while (fast != null && fast.next != null) {
    fast = fast.next.next;
    slow = slow.next;
  }

  return slow;
};
```

[83. Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list)

```js
// My Codding
var deleteDuplicates = function (head) {
  let h = head;
  // 1>1>1>1>2>2>3>3>3: h:
  while (h != null) {
    while (h.next != null && h.val == h.next.val) h.next = h.next.next;

    h = h.next;
  }

  return head;
};
```

[21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists)

```js
// My Solution and Codding
// list1: 1-2-4
// list2: 1-3-4
// Merged:
var mergeTwoLists = function (list1, list2) {
  let merged = new ListNode();
  let temp = merged;

  while (list1 != null && list2 != null) {
    if (list1.val <= list2.val) {
      temp.next = list1;
      list1 = list1.next;
    } else {
      temp.next = list2;
      list2 = list2.next;
    }
    temp = temp.next;
  }

  if (list1 != null) {
    temp.next = list1;
  } else {
    temp.next = list2;
  }

  return merged.next;
};
```

# Stack and Queue

## Building a Stack

```js
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

console.log(stack.pop());
console.log(stack.peek());
console.log(stack.pop());
console.log(stack.pop());
console.log(stack.pop());
```
