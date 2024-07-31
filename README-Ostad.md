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
