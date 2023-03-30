package CodingBat.Warmup1;
// https://codingbat.com/prob/p184004
/*
Given an int n, return true if it is within 10 of 100 or 200. Note: Math.abs(num) computes the absolute value of a number.

nearHundred(93) → true
nearHundred(90) → true
nearHundred(89) → false
 */
public class NearHundred {

    public static boolean nearHundred(int n) {
        int absoluteValue100 = Math.abs(n - 100);
        int absoluteValue200 = Math.abs(n - 200);

        if (absoluteValue100 <= 10 || absoluteValue200 <= 10) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 93;
        System.out.println(nearHundred(n));
    }
}
