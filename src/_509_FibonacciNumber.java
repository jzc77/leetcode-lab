// https://leetcode.com/problems/fibonacci-number/

/*
Thought process:
-Need base case for 1 and 2
 */

public class _509_FibonacciNumber {

    public static int fib(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        // F(n) = F(n - 1) + F(n - 2), for n > 1
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}