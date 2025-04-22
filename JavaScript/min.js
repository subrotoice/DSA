// 1️⃣ Find the Minimum Element in an Array

function intersection(arr) {
  return arr.reduce((min, item) => (min > item ? item : min));
}

console.log(intersection([5, 2, 9, 4, 7]));
