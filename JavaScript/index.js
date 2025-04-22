function maxLength(arr) {
  return arr.reduce((acc, current) =>
    acc.length < current.length ? current : acc
  );
}

console.log(maxLength(["apple4323", "banana", "cherry", "blueberry"]));
