public class Recursion {
    public int fact(int n) {
        if (n == 1) return 1;
        // System.out.println(n);
        return fact(n-1);
    }

    public int fibonacci(int n) {
        if (n == 1) return 1;
        
        return fact(n-1);
    }

}
