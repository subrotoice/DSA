function fun(n) {
  if (n == 0) return 0;
  console.log(n);
  fun(n - 1);
}

fun(5);
