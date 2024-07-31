let arr = [5, 6, 1, 24, 9, 2];
let arrLenght = arr.length;

console.log(arrMin(arr, arrLenght));
console.log(arrMax(arr, arrLenght));
console.log(arrSum(arr));

function arrMin(arr, n) {
  if (n == 1) return arr[0];

  return Math.min(arr[n - 1], arrMin(arr, n - 1));
}

function arrMax(arr, n) {
  if (n == 1) return arr[0];

  return Math.max(arr[n - 1], arrMax(arr, n - 1));
}

// let arr = [5, 6, 1, 24, 9, 2];
function arrSum(arr) {
  const arrLenght = arr.length;
  if (arrLenght == 1) return arr[0];

  arr.length = arrLenght - 1;
  console.log(arr[arrLenght - 1]);
  return arr[arrLenght - 1] + arrSum(arr);
}
