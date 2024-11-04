// 2️⃣ Check if an Array is Sorted

function isSorted(arr) {
  let length = arr.length;
  if (length === 0) return true;

  for (let index = 0; index < length - 1; index++) {
    if (arr[index] > arr[index + 1]) return false;
  }

  return true;
}

console.log(isSorted([5, 3, 4, 1]));
