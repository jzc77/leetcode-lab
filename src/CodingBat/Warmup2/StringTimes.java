package CodingBat.Warmup2;
// https://codingbat.com/prob/p142270
/*
Given a string and a non-negative int n, return a larger string that is n copies of the original string.

stringTimes("Hi", 2) → "HiHi"
stringTimes("Hi", 3) → "HiHiHi"
stringTimes("Hi", 1) → "Hi"
 */
public class StringTimes {
    public static String stringTimes(String str, int n) {
        String result = "";

        for (int i=0; i<n; i++) {
            result += str;
        }

        return result;
    }
    public static void main(String[] args) {
        String str = "Hi";
        int n = 3;
        System.out.println(stringTimes(str, n));
    }
}
