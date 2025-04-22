// 4️⃣ Find the Intersection of Two Arrays

function intersection(arr1, arr2) {
  let newArr = [];
  arr1.forEach((element) => {
    if (arr2.includes(element)) newArr.push(element);
  });

  return newArr;
}

console.log(intersection([1, 2, 3, 5, 8], [2, 3, 5, 8]));
