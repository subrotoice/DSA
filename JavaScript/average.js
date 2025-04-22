// 3️⃣ Find the Average of an Array

function average(arr) {
  let sum = arr.reduce((sum, current) => sum + current);

  return sum / arr.length;
}

console.log(average([10, 20, 30, 40]));
