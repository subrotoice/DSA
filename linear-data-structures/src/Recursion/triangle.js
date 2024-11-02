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
