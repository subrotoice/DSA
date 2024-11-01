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

[206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list)

```js
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
// 1-2-3-4-5
// p-c-n
//   p-c-n
//     p-c-n
var reverseList = function (head) {
  if (head == null || head.next == null) return head;

  // let previous = new ListNode(head.val, null);
  let previous = new ListNode(head.val);
  let current = head.next;

  while (current != null) {
    var next = current.next; //p=1, c=2, n=3-4
    current.next = previous; // c=2-1-2-3-4
    previous = current;
    current = next;
  }

  return previous;
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

[20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

```js
// Basic solution
/**
 * @param {string} s
 * @return {boolean}
 */
// ()[]{}
var isValid = function (s) {
  let stack = [];
  let openingBr = ["(", "{", "["];
  let closingBr = [")", "}", "]"];

  for (let i = 0; i < s.length; i++) {
    let c = s[i];
    if (openingBr.includes(c)) {
      console.log(s[i]);
      stack.push(c);
    } else if (closingBr.includes(c)) {
      let t = stack.pop(); // )
      if (
        (c == ")" && t != "(") ||
        (c == "}" && t != "{") ||
        (c == "]" && t != "[")
      )
        return false;
    }
  }
  return stack.length == 0;
};
```

Optimized: 20. Valid Parentheses

```js
// Optimized
var isValid = function (s) {
  let stack = [];
  let brakets = {
    "(": ")",
    "{": "}",
    "[": "]",
  };

  for (let i = 0; i < s.length; i++) {
    let c = s[i];
    if (brakets[c] != undefined) stack.push(c);
    else if (c != brakets[stack.pop()]) return false;
  }

  return stack.length === 0;
};
```

[Redundant Braces](https://www.interviewbit.com/problems/redundant-braces/)

```js
module.exports = {
  //param A : string
  //return an integer
  braces: function (A) {
    let stack = [];
    let isOperatorFound = false;
    let top;

    for (let i = 0; i < A.length; i++) {
      let c = A[i];
      if (c != ")") stack.push(c);
      else {
        top = stack.pop();
        while (top != "(") {
          if (["+", "-", "*", "/"].includes(top)) {
            isOperatorFound = true;
          }
          top = stack.pop();
        }

        if (!isOperatorFound) return 1;
        isOperatorFound = false;
      }
    }

    return 0;
  },
};
```

# Problem Solving on Searching

- Binary search most important. Here you just think about in which direction range to move by right = mid -1 and left = mid +1;

[69. Sqrt(x)](https://leetcode.com/problems/sqrtx/description/)

- Here use binary search to find sqrt

```js
/**
 * @param {number} x
 * @return {number}
 */
// x = 8
var mySqrt = function (x) {
  if (x === 0) return 0;

  let left = 1;
  let right = x;
  let mid = Math.floor((left + right) / 2);

  while (left <= right) {
    if (mid * mid <= x && (mid + 1) * (mid + 1) > x) return mid;
    else if (mid * mid > x) right = mid - 1;
    else left = mid + 1;
    mid = Math.floor((left + right) / 2);
  }

  return -1;
};
```

[34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

```js
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function (nums, target) {
  return [binarySearch(nums, target, true), binarySearch(nums, target, false)];
};

function binarySearch(arr, target, leftMost) {
  let left = 0;
  let right = arr.length - 1;
  let pos = -1;
  let mid = Math.floor((left + right) / 2);

  while (left <= right) {
    if (arr[mid] == target) {
      pos = mid;
      if (leftMost) right = mid - 1;
      else left = mid + 1;
    } else if (arr[mid] > target) right = mid - 1;
    else left = mid + 1;
    mid = Math.floor((left + right) / 2);
  }

  return pos;
}
```

# Tree

[33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array)

```js
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
  let left = 0;
  let right = nums.length - 1;
  let mid = Math.floor((left + right) / 2);
  console.log(mid);
  // debugger;
  while (left <= right) {
    if (nums[mid] == target) return mid;
    else if (nums[left] <= nums[mid]) {
      if (nums[left] <= target && target <= nums[mid]) right = mid - 1;
      else left = mid + 1;
    } else {
      if (nums[mid] <= target && target <= nums[right]) left = mid + 1;
      else right = mid - 1;
    }

    mid = Math.floor((left + right) / 2);
  }

  return -1;
};
```

[100. Same Tree](https://leetcode.com/problems/same-tree)

```js
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {boolean}
 */
var isSameTree = function (p, q) {
  if (!p && !q) return true;
  if (!p || !q) return false;
  if (p.val !== q.val) return false;
  console.log(typeof p);

  return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
};
```

[110. Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree)

```js
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var findDepth = function (root) {
  if (!root) return 0;

  return 1 + Math.max(findDepth(root.left), findDepth(root.right));
};

var isBalanced = function (root) {
  if (!root) return true;

  let diff = Math.abs(findDepth(root.left) - findDepth(root.right));
  if (diff > 1) return false;

  return isBalanced(root.left) && isBalanced(root.right);
};
```

[101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree)

```js
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetricSubtree = function (p, q) {
  if (!p && !q) return true;
  if (!p || !q) return false;
  if (p.val !== q.val) return false;

  return isSymmetricSubtree(p.left, q.right) && isSymmetricSubtree(p.right, q.left);
};
var isSymmetric = function (root) {
  if (!root.left && !root.right) return true;

  return isSymmetricSubtree(root.left, root.right);
};
```

[. ]()

```js

```

[. ]()

```js

```

[. ]()

```js

```
